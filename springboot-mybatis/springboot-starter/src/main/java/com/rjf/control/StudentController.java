package com.rjf.control;


import com.rjf.mapper.StudentDao;
import com.rjf.pojo.Cls;
import com.rjf.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
