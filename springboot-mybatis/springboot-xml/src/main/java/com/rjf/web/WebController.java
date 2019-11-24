package com.rjf.web;

import com.rjf.mapper.UserMapper;
import com.rjf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getAll")
    List<User> getAll(){
        return userMapper.getAll();
    }
}
