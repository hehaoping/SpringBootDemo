package com.naruto.platform.ui;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.dao.inter.StudentDao;
import com.naruto.platform.schema.Student;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月26日
 */

@RestController
public class StudentUI {
	
	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value="/api/students")
	public JSONArray list(){
		List<Student> list = studentDao.findAll();
		JSONArray ja=new JSONArray();
		ja.addAll(list);
		return ja;
	}
	
	@RequestMapping(value="/api/students",method=RequestMethod.POST)
	public String add(){
		Student s=new Student();
		s.setID(1L);
		s.setName("贺浩平");
		s.setAge(24);
		s.setClassName("软件7班");
		s.setAddTime(new Date());
		s.setAddUser("admin");
		Student news = studentDao.save(s);
		if(news==null){
			return "add fail";
		}
		return "add success";
	}
	
}
