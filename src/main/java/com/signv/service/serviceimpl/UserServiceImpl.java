package com.signv.service.serviceimpl;

import com.signv.dao.UserMapper;
import com.signv.domain.User;
import com.signv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByUserName(String userName) {
        User user = userMapper.findUserByUserName(userName);
        return user;
    }

    public String login(String userName, String userPassword) {
        if(userName!=null){
            User user = userMapper.findUserByUserName(userName);
            if(user != null){
                if(user.getUserPassword().equals(userPassword)){
                    return  "success";
                }else {
                    return "用户名密码错误，请输入正确的用户名密码！";
                }
            }else {
                return "该用户不存在，请输入正确的用户名！";
            }
        }else {
            return "";
        }
    }

    public void modifyUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public List<User> getUserPage(Integer start) {
        return userMapper.getUserPage(start);
    }

    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }

    public void deleteUser(int userId) {
        userMapper.deleteByPrimaryKey(userId);
    }
}
