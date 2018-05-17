package com.xu.dao;

import com.xu.Entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    public void insert(User user);
    public int countAll();
}
