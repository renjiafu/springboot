package com.rjf.es.start;

/*
 *
 *   Rene
 *   2020/7/6 23:38
 */

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Integer> {


    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"id\" : \"?\"}}}}")
    List<User> findById(String id);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"name\" : \"?\"}}}}")
    List<User> findByName(String name);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"hobby\" : \"?\"}}}}")
    List<User> findByHobby(String hobby);

    List<User> findByBirthdayBetween(String startTime, String endTime);
}
