package com.li.test.controller;

import com.li.test.entity.User;
import com.li.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/finduser")
    private String findUserByName(User user, Model model) {
        List<User> userList = testService.findUserByName(user);
        model.addAttribute("userList",userList);
        return "/test/test.jsp";
    }
}
