package com.naruto.platform.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naruto.platform.schema.Student;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月26日
 */
public interface StudentDao extends JpaRepository<Student, Long> {

}
