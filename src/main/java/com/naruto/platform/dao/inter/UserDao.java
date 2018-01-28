package com.naruto.platform.dao.inter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.naruto.platform.schema.User;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月28日
 */
public interface UserDao extends JpaRepository<User, Long> {

	List<User> findByNameLike(String name);

	Page<User> findAll(Pageable pageable);

}
