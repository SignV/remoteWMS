package com.signv.service;

import com.signv.domain.User;

import java.util.List;

public interface UserService {
    User findUserByUserName(String userName);

    String login(String userName,String userPassword);

    void modifyUserInfo(User user);

    List<User> getUserList();

    List<User> getUserPage(Integer start);

    void insertUser(User user);

    void deleteUser(int userId);
}
