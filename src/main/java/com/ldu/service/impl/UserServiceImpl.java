package com.ldu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldu.dao.UserMapper;
import com.ldu.pojo.User;
import com.ldu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	@Override
	public void addUser(User user) {
		userMapper.insert(user);
	}

	@Override
	public User getUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
