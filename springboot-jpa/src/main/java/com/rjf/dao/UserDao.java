package com.rjf.dao;

import com.rjf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *
 *   Rene
 *   2020/6/21 11:12
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    List<User> findByNameLike(String name);
}
