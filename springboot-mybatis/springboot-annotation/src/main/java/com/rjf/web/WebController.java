package com.rjf.web;


import com.rjf.mapper.UserMapper;
import com.rjf.pojo.MysqlUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

   @Autowired
   private UserMapper userMapper;

    @RequestMapping(value = "/getAll")
    public List<MysqlUser> getAll(){
        return userMapper.getAll();
    }

    @RequestMapping(value = "/getOne/{id}")
    public MysqlUser getOne(@PathVariable(value = "id") int id){
        return userMapper.getOne(id);
    }

    @RequestMapping("/insert/{name}/{password}")
    public int insert(@PathVariable String name,@PathVariable String password){
        MysqlUser mysqlUser=new MysqlUser();
        mysqlUser.setName(name);
        mysqlUser.setPassword(password);
        return userMapper.insert(mysqlUser);
    }

    @RequestMapping("/update/{name}/{password}")
    public int update(@PathVariable String name,@PathVariable String password){
        MysqlUser mysqlUser=new MysqlUser();
        mysqlUser.setName(name);
        mysqlUser.setPassword(password);
        return userMapper.update(mysqlUser);
    }

   @RequestMapping("/delete/{id}")
    public int delete(@PathVariable int id){
        return userMapper.delete(id);
   }
}
