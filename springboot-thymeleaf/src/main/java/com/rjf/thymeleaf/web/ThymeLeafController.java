package com.rjf.thymeleaf.web;

import com.rjf.thymeleaf.dao.UserDao;
import com.rjf.thymeleaf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
 *
 *   Rene
 *   2020/6/21 10:44
 */
@Controller
public class ThymeLeafController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String root(){
        return "Root";
    }


    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/findAll")
    public String findAll(Model model){

        List<User> all = userDao.findAll();
        model.addAttribute("users", all);
        return "all";
    }


}
