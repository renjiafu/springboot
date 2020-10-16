package com.rjf.mybatis.dao;

import com.rjf.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class)
    })
    List<User> getAll();

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(column = "id",property = "id",javaType = Integer.class),
            @Result(column = "name",property = "name",javaType = String.class),
            @Result(column = "password",property = "password",javaType =String.class )
    })
    User getUser(int id);

    @Insert("insert into user(name,password) values (#{name},#{password})")
    int insert(User user);

    @Update("update user set name=#{name},password=#{password} where id=#{id}")
    int update( User user);

    @Delete("delete from user where id=#{id}")
    int delete(Integer id);

}