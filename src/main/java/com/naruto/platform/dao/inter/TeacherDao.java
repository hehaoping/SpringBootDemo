package com.naruto.platform.dao.inter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naruto.platform.schema.Teacher;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月27日
 */
public interface TeacherDao extends JpaRepository<Teacher, Long> {

	List<Teacher> findBySchoolID(long schoolID);

	List<Teacher> findByNameLike(String name);

	@Query(value = "select * from teacher where name=?1", nativeQuery = true)
	List<Teacher> findTeacherSchoolInfo(String name);

	@Query(value = "select t.name as teacherName,s.name as schoolName from teacher t left join school s on t.schoolID=s.id where s.id=?1", nativeQuery = true)
	List<Object[]> findTeacherAndSchoolInfo(long schoolID);

}
