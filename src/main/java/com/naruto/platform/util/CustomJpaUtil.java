package com.naruto.platform.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月28日
 */
@Component
public class CustomJpaUtil {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryListBySQL(String sql, Object... args) {
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
