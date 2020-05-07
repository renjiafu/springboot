package com.rjf.mybatis.quickstart.web;


import com.rjf.mybatis.quickstart.mapper.StudentDao;
import com.rjf.mybatis.quickstart.common.Result;
import com.rjf.mybatis.quickstart.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    Result result;

    @PostMapping("/saveOrUpdateStudent")
    public Result saveOrUpdateStudent(@RequestBody Student student) {

        if (student.getId() != null){
            int count=studentDao.updateStudent(student);

            result.setStatus("success");
            result.setCode("200");
            result.setMsg("更新成功 !!!");
            return result;
        }else {
            int count = studentDao.insertStudent(student);

            result.setStatus("success");
            result.setCode("200");
            result.setMsg("插入成功 !!!");
            return result;
        }

    }

    @GetMapping("/getStudentById")
    public Result getStudentById(@RequestBody Student student){

        List<Student> studentList=new ArrayList<>();

        studentList.add(studentDao.getStudentById(student));

        result.setStatus("success");
        result.setCode("200");
        result.setMsg("单查询");
        result.setDate(studentList);
        return result;

    }

    @PostMapping("/getStudentByStudent")
    public Result getStudentByStudent(@RequestBody Student student){
        List<Student> studentList=new ArrayList<>();

        studentList=studentDao.getStudentByStudent(student);

        result.setStatus("success");
        result.setCode("200");
        result.setMsg("多查询");
        result.setDate(studentList);
        return result;

    }

    @GetMapping("/getStudentList/{curPage}/{pageSize}")
    public List<Student> getStudentList(@PathVariable("curPage") Integer curPage,@PathVariable("pageSize") Integer pageSize){
        List<Student> studentList = new ArrayList<>();

        studentList = studentDao.getStudentList((curPage-1)*pageSize,pageSize);
        return studentList;
    }

    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody List<Integer> ids){

        int count=studentDao.deleteStudent(ids);

        result.setStatus("success");
        result.setCode("200");
        result.setMsg("删除 "+count+" 条");
        return result;
    }

}
