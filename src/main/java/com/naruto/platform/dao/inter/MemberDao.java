package com.naruto.platform.dao.inter;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.schema.Member;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月23日
 */
public interface MemberDao {

	public JSONArray list();
	
	public int add(Member m);

	public int update(Member m);

	public int delete(Member m);

	public Member get(long id);

}
