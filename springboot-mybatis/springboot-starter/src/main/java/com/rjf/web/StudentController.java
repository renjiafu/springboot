package com.rjf.web;


import com.rjf.mapper.StudentDao;
import com.rjf.pojo.Cls;
import com.rjf.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @GetMapping("/getOne/{sid}")
    public Student  getOne(@PathVariable("sid") int sid){
        return studentDao.getOne(sid);
    }

    @GetMapping("/getStudent/{sid}")
    public Student getStudent(@PathVariable("sid") int sid){
        return studentDao.getStudent(sid);
    }

    @GetMapping("/getClsById/{cid}")
    public Cls getClsById(@PathVariable("cid") int cid){
        return studentDao.getClsById(cid);
    }

    @PostMapping("/getStudentByStudent")
    public Student getStudentByStudent(@RequestBody Student student){
        return studentDao.getStudentByStudent(student);
    }

    @PostMapping("/getStudentByStudentParam")
    public Student getStudentByStudentParam(@RequestBody Student student){

        return studentDao.getStudentByStudentParam(student);
    }

    @GetMapping("/getClsByTwoObjParam")
    public Cls getClsByTwoObjParam(){

        Student student=new Student();
        student.setSid(1);
        student.setSname("xiaoming");

        Cls cls=new Cls();
        cls.setCid(1);
        cls.setCname("一班");

        return studentDao.getClsByTwoObjParam(cls,student);
    }

    @GetMapping("/insertStudent")
    public String insertStudent(){
        Student student=new Student(20,"xiaohu","888888",1,99);
        return studentDao.insertStudent(student).toString();
    }



}
