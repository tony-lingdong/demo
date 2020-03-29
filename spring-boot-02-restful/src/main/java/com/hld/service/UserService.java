package com.hld.service;

import com.hld.entities.User;

import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.service
 * @version: 1.0
 */
public interface UserService {
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void insertUser(User user);
    void deleteUser(int id);
    User getUserByNameAndPw(String username,String password);
    User getUserByName(String username);
}
