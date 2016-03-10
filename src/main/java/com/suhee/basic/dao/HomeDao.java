package com.suhee.basic.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suhee.basic.model.MemberModel;

@Repository
public class HomeDao {

	@Autowired
	private SqlSession sqlsession;
	
	public List<MemberModel> test() throws Exception {
		return sqlsession.selectList("com.suhee.basic.dao.HelloMapper.getMemberList");
	}
}
