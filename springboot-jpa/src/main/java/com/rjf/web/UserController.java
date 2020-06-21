package com.rjf.web;

import com.rjf.dao.UserDao;
import com.rjf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *
 *   Rene
 *   2020/6/21 10:44
 */
@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String root(){
        return "Root";
    }


    @GetMapping("findAll")
    public List<User> findAll(){
        return userDao.findAll();
    }


    @GetMapping("/findByNameLike/{name}")
    public List<User> findByNameLike(@PathVariable("name") String name){

        return userDao.findByNameLike(name);
    }
}
