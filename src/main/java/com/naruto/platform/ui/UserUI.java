package com.naruto.platform.ui;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.dao.inter.UserDao;
import com.naruto.platform.schema.User;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月28日
 */
@RestController
public class UserUI {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/api/user")
	public JSONArray list() {
		List<User> list = userDao.findAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		return ja;
	}

	@RequestMapping(value = "/api/searchuser")
	public JSONArray search(@RequestParam(required = false, defaultValue = "") String name) {
		JSONArray ja = new JSONArray();
		if (name.equals("")) {
			return ja;
		}
		List<User> list = userDao.findByNameLike("%" + name + "%");
		ja.addAll(list);
		return ja;
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	public String add(User user) {
		User u = new User();
		if (user.getId() != null) {
			u.setId(user.getId());
		} else {
			u.setId(1L);
		}
		String name = user.getName();
		if (name == null) {
			name = "admin";
		}
		u.setName(name);
		u.setAddTime(new Date());
		u.setAddUser("admin");
		User save = userDao.save(u);
		if (save == null) {
			return "add fail";
		}
		return "add success";
	}

}
