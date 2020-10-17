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
            @Result(property = "id", column = "user_id", javaType = Integer.class),
            @Result(property = "name", column = "user_name", javaType = String.class),
            @Result(property = "password", column = "user_password", javaType = String.class)
    })
    List<User> getAll();

    @Select("select * from user where user_id=#{id}")
    @Results({
            @Result(column = "id",property = "user_id",javaType = Integer.class),
            @Result(column = "name",property = "user_name",javaType = String.class),
            @Result(column = "password",property = "user_password",javaType =String.class )
    })
    User getUser(int id);

    @Insert("insert into user(user_name,user_password) values (#{name},#{password})")
    int insert(User user);

    @Update("update user set user_name=#{name},user_password=#{password} where user_id=#{id}")
    int update( User user);

    @Delete("delete from user where user_id=#{id}")
    int delete(Integer id);

}