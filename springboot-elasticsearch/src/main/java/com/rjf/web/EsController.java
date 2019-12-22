package com.rjf.web;

import com.rjf.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/insert")
    public String insert(){
     /*   User user=new User("1","xiaoming","123456");
        userRepo.save(user);*/
        return "添加成功!";
    }
/*
    @GetMapping("/delete")
    public void delete(){
        Integer id=1;
        userRepo.deleteById(String.valueOf(id));
    }

    @GetMapping("/getByName")
    public String getByName(String name){
        List<User> list=new ArrayList<>();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<User> iterable = userRepo.search(matchQueryBuilder);

        iterable.forEach(e->list.add(e));

        return list.toString();
    }

    @GetMapping("/update")
    public String update(){
        User user=new User("id","xiaoli","999999");
        Optional<User> OptUser=userRepo.findById("1");
        OptUser.ifPresent(s->{
            userRepo.save(user);
        });
        return "更新成功!";
    }*/
}
