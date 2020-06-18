package com.rjf.mybatis.web;



import com.rjf.mybatis.dao.UserDao;
import com.rjf.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

   @Autowired
   private UserDao userDao;

    @GetMapping(value = "/getAll")
    public List<User> getAll(){
        return userDao.getAll();
    }


    @GetMapping("/insert/{name}/{password}")
    public int insert(@PathVariable String name,@PathVariable String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userDao.insert(user);
    }


    @GetMapping("/update/{id}/{name}/{password}")
    public int update(@PathVariable("id") Integer id,@PathVariable("name") String name,@PathVariable("password") String password){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userDao.update(user);
    }


   @GetMapping("/delete/{id}")
    public int delete(@PathVariable int id){
        return userDao.delete(id);
   }

}
