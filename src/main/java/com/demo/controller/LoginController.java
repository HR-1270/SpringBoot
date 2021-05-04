package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

//登录控制controller
@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String Login() {
        return "index";
    }

    @PostMapping("/login")
    public String Main(HttpSession session, User user, Model model) {
        //如果用户名或者密码有一个为空则不做考虑
        //这是用户名和密码有长度的，就是不为空的
        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            //用户名和密码不为空那么就要考虑此用户名在数据库中是否有密码，或者密码是否比配
            String password = userService.getPassword(user.getUsername());
            if (!user.getPassword().equals(password) || password == null || password.equals("")) {
                model.addAttribute("msg", "用户名或者密码错误!");
                return "index";
            } else {
                session.setAttribute("loginUser", user);
                //登陆成功重定向到main.html
                return "redirect:/main";
            }
        } else {
            model.addAttribute("msg", "用户名或者密码不能为空");
            return "index";
        }
    }
}
