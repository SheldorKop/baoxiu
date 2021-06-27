package com.example.demo11.controller;

import com.example.demo11.entity.User;
import com.example.demo11.service.BaoxiuService;
import com.example.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    BaoxiuService baoxiuService;

    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Object ob = request.getSession().getAttribute("user");
        if (null == ob) {
            modelAndView.setViewName("login");
        } else {
            request.setAttribute("baoxius", baoxiuService.query((User) ob));
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

}
