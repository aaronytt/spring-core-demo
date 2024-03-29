//package com.ytt.springcoredemo.redis.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 16:34 2019/5/30
// * @Modiflid By:
// */
//@Configuration
//@Slf4j
//public class RedisConfig {
//
//    @Value("${spring.redis.database}")
//    private String database;
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.jedispool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedispool.max-wait}")
//    private long maxWaitMillis;
//
//    @Value("${spring.redis.block-when-exhausted}")
//    private boolean blockWhenExhausted;
//
//    @Bean
//    public JedisPool redisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
//        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
//        // 是否启用pool的jmx管理功能, 默认true
//        jedisPoolConfig.setJmxEnabled(true);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
//        log.info("JedisPool注入成功！！");
//        log.info("redis地址：" + host + ":" + port);
//        return jedisPool;
//    }
//
//}
