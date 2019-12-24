package com.rjf.web;

import com.rjf.mapper.UserMapper;
import com.rjf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getAll")
    List<User> getAll(){
        return userMapper.getAll();
    }


    @GetMapping("/getById/{id}")
    User findById(@PathVariable("") int id){
        return userMapper.getById(id);
    }

    @GetMapping("/insert/{name}/{password}")
    int insert(@PathVariable("name") String name,@PathVariable("password") String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.insert(user);
    }

    @GetMapping("/update/{id}/{name}/{password}")
    int update(@PathVariable("id") Integer id,@PathVariable("name") String name,@PathVariable("password") String password){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userMapper.update(user);
    }

    @GetMapping("/delete/{id}")
    int delete(@PathVariable("id") int id){
        return userMapper.delete(id);
    }


    //choose
    @GetMapping("/getUserLikeNameOrPassword/{name}/{password}")
    User getUserLikeNameOrPassword(@PathVariable("name") String name,@PathVariable("password") String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.getUserLikeNameOrPassword(user);
    }

    //trim
    @GetMapping("/getUserLike/{name}/{password}")
    User getUserLike(@PathVariable("name") String name,@PathVariable("password") String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.getUserLike(user);
    }



}
