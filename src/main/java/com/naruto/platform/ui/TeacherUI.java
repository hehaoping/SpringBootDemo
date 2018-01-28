package com.naruto.platform.ui;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.dao.inter.SchoolDao;
import com.naruto.platform.dao.inter.TeacherDao;
import com.naruto.platform.repo.StudentExtendsRepository;
import com.naruto.platform.schema.School;
import com.naruto.platform.schema.Teacher;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月27日
 */

@RestController
public class TeacherUI {

	@Autowired
	private SchoolDao schoolDao;

	@Autowired
	private StudentExtendsRepository sbr;

	@Autowired
	private TeacherDao teacherDao;

	@RequestMapping("/api/initSchoolAndTeacher")
	public String initSchoolAndTeacher() {

		// 初始化三个学校
		for (int i = 1; i < 4; i++) {
			School s = new School();
			s.setId(i);
			s.setName("长沙第" + i + "中学");
			s.setAddtime(new Date());
			s.setAdduser("admin");
			schoolDao.save(s);
		}
		// 初始化10个老师
		for (int i = 1; i < 11; i++) {
			Teacher t = new Teacher();
			t.setId(i);
			t.setName("老师" + i);
			int schoolID = i % 3;
			if (schoolID == 0) {
				schoolID = 3;
			}
			t.setSchoolID(schoolID);
			t.setAddtime(new Date());
			t.setAdduser("admin");
			teacherDao.save(t);
		}

		return "初始化成功!";
	}

	@RequestMapping("/api/getTeacherBySchool")
	public JSONArray getTeacherBySchool() {
		List<Teacher> list = teacherDao.findBySchoolID(2);
		// List<Teacher> list = teacherDao.findByNameLike("%2%");
		// List<Teacher> list = teacherDao.findTeacherSchoolInfo("老师5");
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		return ja;
	}

	@RequestMapping("/api/findTeacherAndSchoolInfo")
	public JSONArray getTeacherBySchoolID() {
		List<Object[]> list = teacherDao.findTeacherAndSchoolInfo(2);
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		return ja;
	}

	@RequestMapping("/api/findSchoolAndTeacherInfo")
	public JSONArray SchoolAndTeacherInfo() {
		String sql = "select t.name as teacherName,s.name as schoolName from teacher t left join school s on t.schoolID=s.id where s.id=?1";
		JSONArray ja = new JSONArray();
		List<Map<String, Object>> list = sbr.listBySQL(sql, 2);
		ja.addAll(list);
		return ja;
	}

	@RequestMapping("/api/findPageSchoolAndTeacherInfo")
	public JSONArray getPageSchoolAndTeacherInfo() {
		String sql = "select t.name as teacherName,s.name as schoolName from teacher t left join school s on t.schoolID=s.id where s.id=?1";
		JSONArray ja = new JSONArray();
		Pageable pageable = new PageRequest(0, 20);
		Page<Map<String, Object>> pageList = sbr.pageListBySQL(sql, pageable, 1);
		List<Map<String, Object>> content = pageList.getContent();
		System.out.println("共：" + pageList.getTotalPages() + "页");
		System.out.println("共：" + pageList.getTotalElements() + "条记录");
		ja.addAll(content);
		return ja;
	}

}
