package com.rjf.dao;

import com.rjf.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ElasticsearchRepository<User,String> {

}
