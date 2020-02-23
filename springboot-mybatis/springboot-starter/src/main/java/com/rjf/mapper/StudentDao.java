package com.rjf.mapper;

import com.rjf.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao {

    Integer insertStudent(Student student);

    Student getStudentById(Student student);

    //多条件查询
    List<Student> getStudentByStudent(Student student);

    //更新
    Integer updateStudent(Student student);

    //删除
    Integer deleteStudent(List<Integer> ids);


}
