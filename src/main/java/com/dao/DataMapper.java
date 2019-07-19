package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * @title DataMapper.java
 * @description TODO
 * @time 2019/07/17 15:03:18
 * @author chenwq
 * @version 1.0
 */
public interface DataMapper {

	@Select("SELECT a.USER_ID, a.USERNAME, a.`PASSWORD`, a.DEPT_ID, a.EMAIL, a.MOBILE, a.`STATUS`, a.CREATE_TIME, a.MODIFY_TIME, a.LAST_LOGIN_TIME, a.SSEX, a.IS_TAB, a.THEME, a.AVATAR, a.DESCRIPTION FROM t_user AS a WHERE 1=1 order by a.USER_ID")
	List<HashMap<String, String>> test1();

	@Select("SELECT a.SCHED_NAME, a.TRIGGER_NAME, a.TRIGGER_GROUP, a.JOB_NAME, a.JOB_GROUP, a.DESCRIPTION, a.NEXT_FIRE_TIME, a.PREV_FIRE_TIME, a.PRIORITY, a.TRIGGER_STATE, a.TRIGGER_TYPE, a.START_TIME, a.END_TIME, a.CALENDAR_NAME, a.MISFIRE_INSTR, a.JOB_DATA FROM qrtz_triggers AS a")
	List<HashMap<String, String>> test2();

}
