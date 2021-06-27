package com.example.demo11.controller;

import com.example.demo11.entity.User;
import com.example.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }


    @RequestMapping("/toRegister")
    public ModelAndView toRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }


    @RequestMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User user1 = userService.login(user);
        if (null == user1) {
            request.setAttribute("message", "账号密码错误");
            modelAndView.setViewName("login");
        } else {
            request.setAttribute("message", "");
            request.getSession().setAttribute("user", user1);
            modelAndView.setViewName("redirect:/baoxiu");
        }
        return modelAndView;
    }


    @RequestMapping("/register")
    public ModelAndView register(String username, String password, String retryPassword, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        if (username.isEmpty() || password.isEmpty() || retryPassword.isEmpty()) {
            request.setAttribute("message", "注册失败");
            modelAndView.setViewName("register");
            return modelAndView;
        }
        if (!password.equals(retryPassword)) {
            request.setAttribute("message", "注册失败");
            modelAndView.setViewName("register");
            return modelAndView;
        }
        User user = userService.findByUsername(username);
        if (null != user) {
            request.setAttribute("message", "账号已存在");
            modelAndView.setViewName("register");
            return modelAndView;
        }
        userService.register(username, password);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().removeAttribute("user");
        modelAndView.setViewName("login");
        return modelAndView;
    }


}
