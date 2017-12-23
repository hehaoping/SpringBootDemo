package com.naruto.platform.dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.naruto.platform.dao.inter.MemberDao;
import com.naruto.platform.schema.Member;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2017年12月23日
 */
@Repository
public class MemberDaoImple implements MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Member m) {
		String sql = "insert into member(ID,Name,Age,Email,password) values(?,?,?,?,?)";
		int update = jdbcTemplate.update(sql, m.getID(), m.getName(), m.getAge(), m.getEmail(), m.getPassword());
		return update;
	}

	@Override
	public int update(Member m) {
		return 0;
	}

	@Override
	public int delete(Member m) {
		return 0;
	}

	@Override
	public Member get(long id) {
		String sql = "select * from member where ID=?";
		RowMapper<Member> rm = new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int index) throws SQLException {
				Member m = new Member();
				m.setID(rs.getLong("ID"));
				m.setAge(rs.getInt("Age"));
				m.setEmail(rs.getString("Email"));
				return m;
			}
		};
		Member m = jdbcTemplate.queryForObject(sql, rm, id);
		return m;
	}

	@Override
	public JSONArray list() {
		String sql="select * from member";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		JSONArray ja=new JSONArray();
		ja.addAll(list);
		return ja;
	}

}
