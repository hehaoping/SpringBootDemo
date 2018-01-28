package com.naruto.platform.ui;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.schema.School;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月27日
 */
@RestController
public class SchoolUI {

	@PersistenceContext
	private EntityManager em;

	@RequestMapping("/api/getSchoolCount")
	public String getSchoolCount() {
		String sql = "select count(1) from school ";
		Query q = em.createNativeQuery(sql);
		Object result = q.getSingleResult();
		return result.toString();
	}

	@RequestMapping("/api/getPageSchool")
	public JSONArray getPageSchool() {
		String sql = "select * from school ";
		Query q = em.createNativeQuery(sql, School.class);
		q.setFirstResult(0);
		q.setMaxResults(3);
		@SuppressWarnings("unchecked")
		List<School> list = q.getResultList();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		return ja;
	}

	@RequestMapping("/api/getteacherinfo")
	public String getTeacherInfo() {
		String sql = "select t.name as teacherName,s.name as schoolName from teacher t left join school s on t.schoolID=s.id where s.id=?1";
		Query q = em.createNativeQuery(sql);
		q.setParameter(1, 1);
		q.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> resultList = q.getResultList();
		System.out.println(resultList);
		return "ok";
	}

}
