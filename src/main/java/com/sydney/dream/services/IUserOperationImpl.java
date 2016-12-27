package com.sydney.dream.services;

import com.sydney.dream.dao.IUserOperation;
import com.sydney.dream.model.User;

import java.util.List;

/**
 * Created by Sydney on 2016/12/24.，在没有引入Spring 和Spring MVC 前，这个类的内容没有用到。
 */
public class IUserOperationImpl implements IUserOperation {


    /**
     * 此方法用的是UserMapper.xml 中的配置。
     * @param id
     * @return
     */
    public User getUser01(int id) {
        return null;
    }

    public List<User> getUsers(String name) {
        return null;
    }

    public void addUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteById(int id) {

    }

    public User getUser02(int id) {
        return null;
    }
}
