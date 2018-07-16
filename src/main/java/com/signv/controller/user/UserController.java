package com.signv.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.signv.domain.Admin;
import com.signv.domain.User;
import com.signv.service.AdminService;
import com.signv.service.UserService;
import com.signv.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "user/login";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "userName",required = false)String username,
                        @RequestParam(value = "password",required = false) String password,
                        HttpServletResponse response, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            return "user/index";
        }

        String loginInfo = userService.login(username,password);
        HttpSession session = request.getSession();
        if(loginInfo.equals("success")){
            User userFind = userService.findUserByUserName(username);
            session.setAttribute("user",userFind);
            //判断登录用户是否为管理员
            Admin admin = adminService.findAdminByUserId(userFind.getUserId());
            if(admin!=null){
                session.setAttribute("admin",admin);
            }
            return "user/index";
        }else {
            session.setAttribute("errorInfo",loginInfo);
            return "user/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user",null);
        session.setAttribute("admin",null);
        return "user/login";
    }

    @RequestMapping(value = "/getUserInfo")
    public String getUserInfo(HttpServletRequest request){
//        HttpSession session = request.getSession();
        return "user/getUserInfo";
    }

    @RequestMapping(value = "/modifyUserInfo")
    @ResponseBody
    public String modifyUserInfo(@RequestParam(value = "user")String userJson,HttpServletRequest request){
        User user = JSONObject.parseObject(userJson,User.class);
        userService.modifyUserInfo(user);
        request.getSession().setAttribute("user",user);
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
}

