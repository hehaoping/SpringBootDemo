package com.naruto.platform.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.dao.inter.MemberDao;
import com.naruto.platform.schema.Member;
import com.naruto.platform.util.NoUtil;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月23日
 */
@RestController
public class MmeberUI {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/api/member", method = RequestMethod.POST)
	public String add(Member m) {
		if (m.getID() == null) {
			m.setID(NoUtil.getMaxID(jdbcTemplate, "Member"));
		}
		if (m.getName() == null) {
			m.setName("哈哈");
		}
		int status = memberDao.add(m);
		if (status > 0) {
			return "add success";
		} else {
			return "add fail";
		}
	}

	@RequestMapping("/api/member")
	public JSONArray list() {
		JSONArray list = memberDao.list();
		return list;
	}

}
