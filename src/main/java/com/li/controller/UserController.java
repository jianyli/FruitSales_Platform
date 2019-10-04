package com.li.controller;

import com.li.entity.User;
import com.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    @RequestMapping("/toLogin.action")
    public String toLogin() {
        return "/login.jsp";
    }
    @RequestMapping("/login.action")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        System.out.println(map);
        map.put("password",password);
        List<User> list = userService.find(map);
        if (list != null && list.size()>0) {
            request.getSession().setAttribute("user",list.get(0).getName());
            return "/home.jsp";
        }
        model.addAttribute("errorMsg","密码或账号错误");
        return "/login.jsp";
    }
    @RequestMapping("/registerPage.action")
    public String toRegister() {
        return "/register.jsp";
    }
    @RequestMapping("register.action")
    public String register(User user, Model model, HttpServletRequest request) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",user.getUserName());
        List<User> list = userService.find(map);
        if ((list != null && list.size() > 0)) {
            model.addAttribute("errorMsg","注册失败，用户名已注册");
            return "/register.jsp";
        }
        user.setUserId(UUID.randomUUID().toString());
        userService.insert(user);
        model.addAttribute("noticeMsg","注册成功，请登录");
        return "/login.jsp";
    }
}
