package com.rjf.mapper;

import com.rjf.pojo.MysqlUser;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {

    @Select("select * from mysql_user")
    @Results({
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class)
    })
    List<MysqlUser> getAll();
/*

    @Select("select * from mysql_user where id=#{id}")
    @Results({
            @Result(column = "id",property = "id",javaType = Integer.class),
            @Result(column = "name",property = "name",javaType = String.class),
            @Result(column = "password",property = "password",javaType =String.class )
    })
    MysqlUser getOne(int id);

    @Insert("insert into mysql_user(name,password) values (#{name},#{password})")
    int insert(MysqlUser mysqlUser);

    @Update("update mysql_user set name=#{name},password={#password} where name=#{name}")
    int update(MysqlUser mysqlUser);

    @Delete("delete from mysql_user where id=#{id}")
    int delete(int id);
*/



}