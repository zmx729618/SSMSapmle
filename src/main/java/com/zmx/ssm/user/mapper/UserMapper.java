package com.zmx.ssm.user.mapper;

import org.springframework.stereotype.Repository;

import com.zmx.ssm.user.domain.User;
@Repository
public interface UserMapper {
	
	public void addUser(User user);

}
