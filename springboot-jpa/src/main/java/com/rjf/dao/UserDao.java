package com.rjf.dao;
/*
 * TODO
 *
 * @since 2020/1/1
 */


import com.rjf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User getByName(String name);
}
