package com.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DataMapper;
import com.datasource.DataSource;
import com.datasource.DataSourceType;

/**
 * @title DataService.java
 * @description TODO
 * @time 2019/07/17 15:03:40
 * @author chenwq
 * @version 1.0
 */
@Service
public class DataService {
	@Autowired
	private DataMapper mapper;

	public List<HashMap<String, String>> test1() {
		return mapper.test1();
	}

	@DataSource(value = DataSourceType.TWO)
	public List<HashMap<String, String>> test2() {
		return mapper.test2();
	}

}
