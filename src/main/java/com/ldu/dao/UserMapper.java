package com.ldu.dao;

import com.ldu.pojo.User;

public interface UserMapper {

    public void addUser(User user);
    public User getUserByUserName(String username);
    public User getUserByPhone(String phone);
}
