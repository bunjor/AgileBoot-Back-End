package com.agileboot.infrastructure.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Mybatis支持*匹配扫描包
 *
 * @author valarchie
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

//    // 数据源创建器（必须）
//    @Bean
//    public DataSourceCreator dataSourceCreator() {
//        return new DefaultDataSourceCreator();
//    }

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @Primary
//    public DataSource dynamicDataSource(
//            @Qualifier("masterDataSource") DataSource master,
//            @Qualifier("slaveDataSource") DataSource slave) {
//
//        DynamicRoutingDataSource ds = new DynamicRoutingDataSource();
//        ds.addDataSource("master", master);
//        ds.addDataSource("slave", slave);
//        // 设置默认数据源
//        ds.setPrimary("master");
//        return ds;
//    }
//
//    @Bean
//    public DataSourceTransactionManager transactionManager(
//            @Qualifier("dynamicDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
