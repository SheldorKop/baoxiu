package com.example.demo11.controller;

import com.example.demo11.entity.Baoxiu;
import com.example.demo11.entity.User;
import com.example.demo11.service.BaoxiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/baoxiu")
public class BaoxiuController {

    @Autowired
    BaoxiuService baoxiuService;

    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        User user = (User) request.getSession().getAttribute("user");
        List<Baoxiu> list = baoxiuService.query(user);
        request.setAttribute("baoxius", list);
        return modelAndView;
    }


    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Integer id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Baoxiu baoxiu = baoxiuService.findById(id);
        request.setAttribute("baoxiu", baoxiu);
        return modelAndView;
    }


    @RequestMapping("/edit")
    public ModelAndView edit(Baoxiu baoxiu, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/baoxiu");
        if (baoxiu.getId() == -1) {
            User user = (User) request.getSession().getAttribute("user");
            baoxiu.setUserId(user.getId());
        }
        baoxiuService.edit(baoxiu);
        return modelAndView;
    }


    @RequestMapping("/delete")
    public ModelAndView delete(Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/baoxiu");
        baoxiuService.delete(id);
        return modelAndView;
    }


}
