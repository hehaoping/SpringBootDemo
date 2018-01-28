package com.naruto.platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naruto.platform.schema.Student;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月28日
 */
public interface StudentBaseRepository extends JpaRepository<Student, Long>, StudentBaseRepositoryCustom {

}
