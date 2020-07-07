package com.rjf.es.start.dao;

/*
 *
 *   Rene
 *   2020/7/6 23:38
 */

import com.rjf.es.start.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,Integer> {


//    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"id\" : \"?\"}}}}")
    Page<User> findById(String id, Pageable pageable);

//    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"name.keyword\" : \"?\"}}}}")
    Page<User> findByName(String name, Pageable pageable);

//    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"hobby\" : \"?\"}}}}")
    Page<User> findByHobby(String hobby, Pageable pageable);


}
