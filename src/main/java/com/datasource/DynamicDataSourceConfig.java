package com.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @title DynamicDataSourceConfig.java
 * @description TODO 数据库配置类
 * @time 2019/07/17 14:57:35
 */
@Configuration
public class DynamicDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.druid.one")
	public DataSource oneDataSource() {
		DataSource dataSource = DruidDataSourceBuilder.create().build();
		return dataSource;
	}

	@Bean
	@ConfigurationProperties("spring.datasource.druid.two")
	public DataSource twoDataSource() {
		DataSource dataSource = DruidDataSourceBuilder.create().build();
		return dataSource;
	}

	@Bean
	@Primary
	public MyRoutingDataSource dataSource(DataSource oneDataSource, DataSource twoDataSource) {
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>(2);
		targetDataSources.put(DataSourceType.ONE, oneDataSource);
		targetDataSources.put(DataSourceType.TWO, twoDataSource);
		// 还有数据源,在targetDataSources中继续添加
		return new MyRoutingDataSource(oneDataSource, targetDataSources);
	}
}
