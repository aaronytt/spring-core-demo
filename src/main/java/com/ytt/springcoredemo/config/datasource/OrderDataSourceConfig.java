package com.ytt.springcoredemo.config.datasource;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import com.ytt.springcoredemo.config.datasource.OrderDBConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.ytt.springcoredemo.dao.mapper.order", sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDataSourceConfig {
//    @Bean(name = "test2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.spring2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "orderDataSource")
    public DataSource testDataSource(OrderDBConfig orderDBConfig) {
        DruidXADataSource dataSource = new DruidXADataSource();
        BeanUtils.copyProperties(orderDBConfig,dataSource);

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(dataSource);
        atomikosDataSourceBean.setUniqueResourceName("orderDatasource");
        return atomikosDataSourceBean;

    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/order/*.xml"));
        return bean.getObject();
    }

//    @Bean(name = "test2TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "orderSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}