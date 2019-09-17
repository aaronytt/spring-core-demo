package com.ytt.springcoredemo.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 5:40 2019/9/11
 * @Modiflid By:
 */
@Configuration
@Slf4j
public class RedisClusterConfig {

    @Value("${spring.redis.database}")
    private String database;

//    @Value("${spring.redis.password}")
//    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedispool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedispool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean blockWhenExhausted;

    @Bean
    public JedisCluster redisPoolFactory() {

        String[] cNodes = clusterNodes.split(",");
        Set<HostAndPort> nodes =new HashSet<>();
        //分割出集群节点
        for(String node : cNodes) {
            String[] hp = node.split(":");
            nodes.add(new HostAndPort(hp[0],Integer.parseInt(hp[1])));
        }

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        //带密码
//        JedisCluster jedisCluster = new JedisCluster(nodes, timeout,timeout * 5, 2, password, jedisPoolConfig);
        //没密码
        JedisCluster jedisCluster = new JedisCluster(nodes, timeout,timeout * 5, 2, jedisPoolConfig);

        return jedisCluster;
    }

}
