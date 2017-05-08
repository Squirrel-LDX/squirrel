package com.ldu.service;

import com.ldu.pojo.User;

public interface UserService {

    public void addUser(User user);
    public User getUserByUserName(String username);
    public User getUserByPhone(String phone);
    public User checkLogin(String username,String password);
}