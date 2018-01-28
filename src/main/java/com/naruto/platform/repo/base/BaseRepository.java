package com.naruto.platform.repo.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月28日
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	List<Map<String, Object>> listBySQL(String sql, Object... args);

	Page<Map<String, Object>> pageListBySQL(String sql, Pageable pageable, Object... args);

}
