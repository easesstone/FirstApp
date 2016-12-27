package com.sydney.dream.dao;

import com.sydney.dream.model.User;

import java.util.List;

/**
 * Created by Sydney on 2016/11/30.
 */
public interface IUserOperation {
    public User getUser01(int id);
    public List<User> getUsers(String name);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteById(int id);
    public User getUser02(int id);
}
