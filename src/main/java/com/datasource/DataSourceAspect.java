package com.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @title DataSourceAspect.java
 * @description 切入注解来更换数据源
 * @time 2019/07/17 14:59:08
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class DataSourceAspect {

	/**
	 * 切点: 所有配置 DataSource 注解的方法
	 */
	@Pointcut("@annotation(com.datasource.DataSource)")
	public void dataSourcePointCut() {
	}

	@Around("dataSourcePointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		DataSource ds = method.getAnnotation(DataSource.class);
		DataSourceContextHolder.setDataSourceType(ds.value());
		log.info("当前数据源: " + ds.value());
		try {
			return point.proceed();
		} finally {
			DataSourceContextHolder.clearDataSourceType();
		}
	}

}
