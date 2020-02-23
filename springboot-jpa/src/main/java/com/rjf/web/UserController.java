package com.rjf.web;

import com.rjf.dao.UserDao;
import com.rjf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * TODO
 *
 * @since 2020/1/1
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/getOne")
    public User getOne(){
        return userDao.getOne(1L);
    }

    @GetMapping("/save")
    public User save(){
        User user=new User();
        user.setId(3L);
        user.setName("xiaoming");
        user.setAccount("1553430985");
        user.setPwd("12346");
        return userDao.save(user);
    }

    @GetMapping("/saveAll")
    public String saveAll(){
        List<User> userList=new ArrayList<>();
        User user=new User();
        user.setName("xiaoming");
        user.setAccount("1553430985");
        user.setPwd("12346");
        userList.add(user);
        user.setAccount("15573430985");
        userList.add(user);
        user.setName("xiaohua");
        userList.add(user);

        return "暂无";
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userDao.findAll();
    }

    @GetMapping("/getByName/{name}")
    public User getByName(@PathVariable("name") String name){
        return userDao.getByName(name);
    }

}
