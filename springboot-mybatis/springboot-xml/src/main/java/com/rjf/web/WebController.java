package com.rjf.web;

import com.rjf.mapper.UserMapper;
import com.rjf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/findById/{id}")
    User findById(@PathVariable int id){
        return userMapper.findById(id);
    }

    @RequestMapping("/insert/{name}/{password}")
    int insert(@PathVariable String name,@PathVariable String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.insert(user);
    }

    @RequestMapping("/update/{name}/{password}")
    int update(@PathVariable String name,@PathVariable String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.update(user);
    }

    @RequestMapping("/delete/{id}")
    int delete(@PathVariable int id){
        return userMapper.delete(id);
    }


    //choose
    @RequestMapping("/findUserLikeNameAndPassword/{name}/{password}")
    User findUserLikeNameAndPassword(@PathVariable String name,@PathVariable String password){
        User user=new User();
        //user.setName(name);
        user.setPassword(password);
        return userMapper.findUserLikeNameAndPassword(user);
    }

    //trim
    @RequestMapping("/findUserLike/{name}/{password}")
    User findUserLike(@PathVariable String name,@PathVariable String password){
        User user=new User();
       // user.setName(name);
        user.setPassword(password);
        return userMapper.findUserLike(user);
    }



}
