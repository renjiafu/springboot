package com.rjf.mapper;

import com.rjf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    List<User> getAll();

    User findById(int id);

    int insert(User user);

    int update(User user);

    int delete(int id);

    //choose
    User findUserLikeNameAndPassword(User user);

    //trim
    User findUserLike(User user);

}
