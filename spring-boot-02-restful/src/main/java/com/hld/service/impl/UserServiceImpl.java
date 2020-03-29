package com.hld.service.impl;

import com.hld.entities.User;
import com.hld.mapper.UserMapper;
import com.hld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
            userMapper.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
            userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
            userMapper.deleteUser(id);
    }

    @Override
    public User getUserByNameAndPw(String username, String password) {
        return userMapper.getUserByNameAndPw(username,password);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

}
