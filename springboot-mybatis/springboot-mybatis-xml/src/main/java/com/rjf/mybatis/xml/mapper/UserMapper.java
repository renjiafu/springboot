package com.rjf.mybatis.xml.mapper;

import com.rjf.mybatis.xml.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {


    List<User> getAll();

    User getById(int id);

    int insert(User user);

    int update(User user);

    int delete(int id);

    //choose
    User getUserLikeNameOrPassword(User user);

    //trim
    User getUserLike(User user);

}
