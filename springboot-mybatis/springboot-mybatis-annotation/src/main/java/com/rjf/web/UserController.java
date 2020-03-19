package com.rjf.web;


import com.rjf.mapper.UserMapper;
import com.rjf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

   @Autowired
   private UserMapper userMapper;

    @GetMapping(value = "/getAll")
    public List<User> getAll(){
        return userMapper.getAll();
    }

    @GetMapping(value = "/getOne/{id}")
    public User getOne(@PathVariable("id") int id){
        return userMapper.getOne(id);
    }

    @GetMapping("/insert/{name}/{password}")
    public int insert(@PathVariable String name,@PathVariable String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userMapper.insert(user);
    }

    @GetMapping("/update/{id}/{name}/{password}")
    public int update(@PathVariable("id") Integer id,@PathVariable("name") String name,@PathVariable("password") String password){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userMapper.update(user);
    }

   @GetMapping("/delete/{id}")
    public int delete(@PathVariable int id){
        return userMapper.delete(id);
   }

}
