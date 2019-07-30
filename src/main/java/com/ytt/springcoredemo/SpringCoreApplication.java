package com.ytt.springcoredemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @see InfrastructureAdvisorAutoProxyCreator
 * 1.注册 2.
 * @see AnnotationTransactionAttributeSource 事务增强器要用事务注解信息，使用这个类解析事务注解
 *
 * @see TransactionInterceptor 保存了事务属性信息，事务管理器
 * @see MethodInterceptor
 *
 * 当执行目标方法时：
 *      执行拦截器链
 *      事务
 *      事务拦截器：
 *          1.先获取事务相关属性
 *          2.获取PlatformTransactionManager事务管理器，直接容器中取PlatformTransactionManager 备案实例
 *      执行目标方法：
 *          1.如果异常：completeTransactionAfterThrowing，利用是管理回滚操作
 *          2.如果正常：commitTransactionAfterReturning，利用事务管理器提交事务
 *
 */
//@EnableTransactionManagement
//@ComponentScan("com.ytt")
//@MapperScan("com.ytt.spring.springcore.mybatis.mapper")
@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
    }

}
