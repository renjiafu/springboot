package com.rjf.mapper;

import com.rjf.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao {


    //单查询
    Student getStudentById(Student student);

    //多查询-条件查询
    List<Student> getStudentByStudent(Student student);

    //列表查询
    List<Student> getStudentList(@Param("index") Integer index,@Param("pageSize") Integer pageSize);

    //新增
    Integer insertStudent(Student student);

    //更新
    Integer updateStudent(Student student);

    //删除
    Integer deleteStudent(List<Integer> ids);


}