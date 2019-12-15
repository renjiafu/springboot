package com.rjf.mapper;

import com.rjf.pojo.Cls;
import com.rjf.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentDao {

    Student getOne(int id);

    Student getStudent(int id);

    Cls getCls(int id);

    Student getStudentByStudent(Student student);

    Student getStudentByStudentParam(@Param("student") Student student );

    Cls getClsByTwoObjParam(@Param("cls") Cls cls, @Param("student") Student student);



}
