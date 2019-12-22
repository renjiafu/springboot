package com.rjf.web;


import com.rjf.mapper.StudentDao;
import com.rjf.pojo.Cls;
import com.rjf.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @RequestMapping("/getStudentById/{id}")
    public Student  getOne(@PathVariable("id") int id){
        return studentDao.getOne(id);
    }

    @RequestMapping("/getStudentObjById/{id}")
    public Student getStudentObj(@PathVariable("id") int id){
        return studentDao.getStudent(id);
    }

    @RequestMapping("/getClsObjById/{id}")
    public Cls getClsObj(@PathVariable("id") int id){
        return studentDao.getCls(id);
    }

    @RequestMapping("/getStudentByStudent")
    public Student getStudentByStudent(@RequestBody Student student){
//        @RequestBody Student student
   /*     Student student1=new Student();
        student1.setId(1);*/
        return studentDao.getStudentByStudent(student);
    }

    @RequestMapping("/getStudentByStudentParam")
    public Student getStudentByStudentParam(@RequestBody Student student){

        return studentDao.getStudentByStudentParam(student);
    }

    @RequestMapping("/getClsByTwoObjParam")
    public Cls getClsByTwoObjParam(){

        Student student=new Student();
        student.setId(1);student.setName("xiaoming");

        Cls cls=new Cls();
//        cls.setId(1);cls.setClsName("一班");

        return studentDao.getClsByTwoObjParam(cls,student);
    }

    @GetMapping("/insert")
    public String insert(){
        Student student=new Student(20,"xiaohu","888888",1);
        return studentDao.insert(student).toString();

    }



}
