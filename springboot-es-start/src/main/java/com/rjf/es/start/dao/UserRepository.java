package com.rjf.es.start.dao;

/*
 *
 *   Rene
 *   2020/7/6 23:38
 */

import com.rjf.es.start.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,Integer> {

    @Override
    Optional<User> findById(Integer i);

    Iterable<User> findByName(String name);

    List<User> findByHobby(String s1, String s2);
}
