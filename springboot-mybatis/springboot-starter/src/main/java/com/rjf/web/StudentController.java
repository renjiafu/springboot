package com.rjf.web;


import com.rjf.mapper.StudentDao;
import com.rjf.pojo.BaseResult;
import com.rjf.pojo.Student;
import com.rjf.pojo.StudentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentResult result;

    @PostMapping("/saveOrUpdateStudent")
    public BaseResult saveOrUpdateStudent(@RequestBody Student student) {

        if (student.getStuId() != null){
            int count=studentDao.updateStudent(student);

            result.setStatus("success");
            result.setCode("200");
            result.setMsg("更新成功 !!!");
            return result;
        }else {
            student.setBirthday(new Date());

            int count = studentDao.insertStudent(student);

            result.setStatus("success");
            result.setCode("200");
            result.setMsg("插入成功 !!!");
            return result;
        }

    }

    @GetMapping("/getStudentById")
    public StudentResult getStudentById(@RequestBody Student student){

        List<Student> studentList=new ArrayList<>();

        studentList.add(studentDao.getStudentById(student));

        result.setStatus("success");
        result.setCode("200");
        result.setMsg("单查询");
        result.setStudentList(studentList);
        return result;

    }

    @PostMapping("/getStudentByStudent")
    public StudentResult getStudentByStudent(@RequestBody Student student){
        List<Student> studentList=new ArrayList<>();

        studentList=studentDao.getStudentByStudent(student);


        result.setStatus("success");
        result.setCode("200");
        result.setMsg("多查询");
        result.setStudentList(studentList);
        return result;

    }

    @PostMapping("/deleteStudent")
    public StudentResult deleteStudent(@RequestBody List<Integer> ids){

        int count=studentDao.deleteStudent(ids);


        result.setStatus("success");
        result.setCode("200");
        result.setMsg("删除 "+count+" 条");
        return result;
    }





}
