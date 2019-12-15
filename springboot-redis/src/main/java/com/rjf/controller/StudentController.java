package com.rjf.controller;


import com.rjf.dao.StudentDao;
import com.rjf.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/getStudentById/{id}")
    public String  getOne(@PathVariable("id") int id){

        if (stringRedisTemplate.opsForValue().get(String.valueOf(id))!=null){
            return  "redis : "+stringRedisTemplate.opsForValue().get(String.valueOf(id));
        }

        Student student=studentDao.getOne(id);
        stringRedisTemplate.opsForValue().set(String.valueOf(student.getId()),student.getName());


        return "mysql :"+student.toString();
    }

}
