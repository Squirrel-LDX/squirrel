package com.ldu.service.impl;

import com.ldu.dao.UserMapper;
import com.ldu.pojo.User;
import com.ldu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserByUserName(String username) {
        User user1= userMapper.getUserByUserName(username);
        return user1;
    }

    public User checkLogin(String username,String password) {
        User user = userMapper.getUserByUserName(username);
        if(user!=null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

	@Override
	public User getUserByPhone(String phone) {
		
		return null;
	}
}
