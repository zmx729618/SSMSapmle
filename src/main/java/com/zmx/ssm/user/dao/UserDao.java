package com.zmx.ssm.user.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.zmx.ssm.user.domain.User;

@Repository
public class UserDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession; 
	
	public void addUser(User user) {
		
		sqlSession.insert("com.zmx.ssm.user.mapper.UserMapper.addUser",user);
	}


	
}
