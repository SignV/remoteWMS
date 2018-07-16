package com.signv.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.signv.domain.User;
import com.signv.service.AdminService;
import com.signv.service.UserService;
import com.signv.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    //分页显示用户
    @RequestMapping(value = "/adminGetUserList")
    public String adminGetUserList(Integer first,HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取分页的页数
        List<User> userList = userService.getUserList();
        int size = userList.size();
        int page = size/10;
        List<Integer> pageSize = new ArrayList<Integer>();
        for (int i = 1;i <= page;i++){
            pageSize.add(i+1);
        }
        //分页操作
        Integer start = (first-1) * 10;
        List<User> userPageList = userService.getUserPage(start);
        //保存分页列表
        session.setAttribute("userList",userPageList);
        //保存选中的页数
        session.setAttribute("num",first);
        //保存分页的页数
        session.setAttribute("pageSize",pageSize);
        return "admin/adminGetUserList";
    }

    @RequestMapping(value = "/getUserInfo")
    public String getUserInfo(@RequestParam(value = "username")String username, HttpServletRequest request){
        User userInfo = userService.findUserByUserName(username);
        request.setAttribute("userInfo",userInfo);
        return "admin/getUserInfo";
    }

    @RequestMapping(value = "/modifyUserInfo")
    @ResponseBody
    public String modifyUserInfo(@RequestParam(value = "user")String userJson,HttpServletRequest request){
        User userInfo = JSONObject.parseObject(userJson,User.class);
        userService.modifyUserInfo(userInfo);
        request.getSession().setAttribute("userInfo",userInfo);
        return "success";
    }

    @RequestMapping(value = "/changePassword")
    @ResponseBody
    public JSONObject changePassword(@RequestParam(value = "oldPW")String oldPW,
                                     @RequestParam(value = "newPW1")String newPW,
                                     HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User userPW = userService.findUserByUserName(user.getUserName());
        JSONObject data = new JSONObject();
        if(userPW.getUserPassword().equals(oldPW)){
            userPW.setUserPassword(newPW);
            userService.modifyUserInfo(userPW);
            data.put("changeInfo",true);
            data.put("errorInfo","修改密码成功！");
        }else {
            data.put("changeInfo",false);
            data.put("errorInfo","原密码不正确，请输入正确的密码！");
        }
        ResponseUtil.write(response,data);
        return null;
    }

    @RequestMapping(value = "addUser")
    public String addUser(){
        return "admin/addUser";
    }

    @RequestMapping(value = "checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam(value = "userName")String userName,
                             HttpServletResponse response,
                             HttpServletRequest request){
//        User newUser = JSONObject.parseObject(userJson,User.class);
        User existUser = userService.findUserByUserName(userName);
        JSONObject data = new JSONObject();
        if(existUser == null){
            data.put("changeInfo",true);
            data.put("errorInfo","该用户账号可以使用！");
        }else {
            data.put("changeInfo",false);
            data.put("errorInfo","该用户账号已存在！");
        }
        try {
            ResponseUtil.write(response,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "insertUser")
    @ResponseBody
    public String insertUser(@RequestParam(value = "user")String userJson,
                             HttpServletResponse response,
                             HttpServletRequest request){
        User newUser = JSONObject.parseObject(userJson,User.class);
        User existUser = userService.findUserByUserName(newUser.getUserName());
        JSONObject data = new JSONObject();
        if(existUser == null){
            userService.insertUser(newUser);
            data.put("changeInfo",true);
            data.put("errorInfo","添加用户成功！");
        }else {
            data.put("changeInfo",false);
            data.put("errorInfo","该用户账号已存在！");
        }
        try {
            ResponseUtil.write(response,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除用户的信息
    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public String deleteGoods(@RequestParam(value = "userId")int userId,HttpServletRequest request){
        userService.deleteUser(userId);
        return "success";
    }
}
