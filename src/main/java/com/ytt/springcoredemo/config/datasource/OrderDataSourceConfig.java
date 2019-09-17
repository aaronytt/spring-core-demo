package com.ytt.springcoredemo.config.datasource;

import com.ytt.springcoredemo.dao.handler.OrderStateTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.ytt.springcoredemo.dao.mapper.order", sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDataSourceConfig {
//    @Bean(name = "test1DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.spring")
//    @Primary
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Value("mybatis.type-handlers-package")
    private String typeAliasesPackage;

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("orderDatasource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("org.apache.ibatis.type");
        bean.setTypeHandlers(new OrderStateTypeHandler());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/order/*.xml"));
        return bean.getObject();
    }

//    @Bean(name = "test1DataSource")
//    @Primary
//    public DataSource testDataSource(DBConfig1 config1) {
//        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
//        mysqlXADataSource.setUrl(config1.getJdbcUrl());
//        mysqlXADataSource.setPassword(config1.getPassword());
//        mysqlXADataSource.setUser(config1.getUsername());
//
//        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
//        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
//        atomikosDataSourceBean.setUniqueResourceName("test1Datasource");
//        return atomikosDataSourceBean;
//
//    }


//    @Bean(name = "test1TransactionManager")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}