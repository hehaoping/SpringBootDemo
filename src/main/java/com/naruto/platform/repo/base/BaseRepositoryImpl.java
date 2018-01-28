package com.naruto.platform.repo.base;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月28日
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private final EntityManager em;

	// 父类没有不带参数的构造方法，这里手动构造父类
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.em = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listBySQL(String sql, Object... args) {
		List<Map<String, Object>> resultList = null;
		try {
			Query q = em.createNativeQuery(sql);
			for (int i = 0; i < args.length; i++) {
				q.setParameter(i + 1, args[i]);
			}
			q.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			resultList = q.getResultList();
		} catch (Exception e) {
			resultList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Page<Map<String, Object>> pageListBySQL(String sql, Pageable pageable, Object... args) {
		Page<Map<String, Object>> pages = null;
		try {
			Query q = em.createNativeQuery(sql);
			String totalSQL = "select count(1) from ( " + sql + " ) tempTotalTable ";
			Query totalQ = em.createNativeQuery(totalSQL);
			for (int i = 0; i < args.length; i++) {
				q.setParameter(i + 1, args[i]);
				totalQ.setParameter(i + 1, args[i]);
			}
			q.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			q.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
			q.setMaxResults(q.getFirstResult() + pageable.getPageSize());
			long total = Long.valueOf(totalQ.getSingleResult().toString());
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> resultList = q.getResultList();
			pages = new PageImpl<>(resultList, pageable, total);
		} catch (Exception e) {
			pages = new PageImpl<>(new ArrayList<>());
			e.printStackTrace();
		}
		return pages;
	}
}
