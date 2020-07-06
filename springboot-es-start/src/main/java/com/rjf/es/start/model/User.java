package com.rjf.es.start.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/*
 *
 *   Rene
 *   2020/7/6 23:21
 */
@Document(indexName = "index001", type = "_doc")
public class User implements Serializable {

    @Id
    private Integer id;

    /*
     *   姓名
     * */
    private String name;

    /*
     *   爱好
     * */
    private String hobby;

    public User(Integer id, String name, String hobby) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
