package com.puzzle.nim.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.puzzle.nim.repository.mapper.NimQuestionMapper;

@Configuration
// @ConfigurationProperties(prefix = "spring.datasource")
// @MapperScan(basePackages = "com.puzzle.nim.repository.mapper")
public class MyBatisConfig {
    // private final String url;

    // public MyBatisConfig(String url) {
    //     this.url = url;
    // }

    // @Bean
    // public DataSource dataSource() {
    //     return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/nim").build();
    // }

    // @Bean
    // public SqlSessionFactoryBean sqlSessionFactoryBean() {
    //     SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    //     factoryBean.setDataSource(dataSource());
    //     // factoryBean.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
    //     return factoryBean;
    // }

    // @Bean
    // public MapperFactoryBean<NimQuestionMapper> nimQuestionMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
    //     MapperFactoryBean<NimQuestionMapper> factoryBean = new MapperFactoryBean<>(NimQuestionMapper.class);
    //     factoryBean.setSqlSessionFactory(sqlSessionFactory);
    //     return factoryBean;
    // }
}