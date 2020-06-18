package com.rjf.mybatis.dao;

import com.rjf.mybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
