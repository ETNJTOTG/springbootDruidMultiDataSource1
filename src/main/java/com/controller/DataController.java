package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.service.DataService;

/**
 * @title DataController.java
 * @description TODO
 * @time 2019/07/17 13:15:30
 * @author chenwq
 * @version 1.0
 */
@RestController
public class DataController {
	@Autowired
	private DataService dataService;

	@RequestMapping("/getTest")
	public JSONObject getTest() {
		JSONObject result = new JSONObject();
		result.put("test1", dataService.test1());
		result.put("test2", dataService.test2());
		return result;
	}
}
