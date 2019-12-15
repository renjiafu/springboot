package com.rjf.dao;

import com.rjf.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentDao {

    @Select("select * from student where id=#{id}")
    Student getOne(int id);


}
