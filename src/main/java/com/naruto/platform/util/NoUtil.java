package com.naruto.platform.util;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月23日
 */
public class NoUtil {

	public static synchronized long getMaxID(JdbcTemplate jdbcTemplate, String tableName) {
		if (tableName != null) {
			String sql = "select max(ID) as maxID from "+tableName;
			Map<String, Object> map = jdbcTemplate.queryForMap(sql);
			Long maxID = (Long) map.get("maxID");
			return maxID + 1;
		}
		return 1;
	}

}
