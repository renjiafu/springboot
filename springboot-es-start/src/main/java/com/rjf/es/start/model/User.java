package com.rjf.es.start.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/*
 *
 *   Rene
 *   2020/7/6 23:21
 */
@Document(indexName = "index001", shards = 1, replicas = 0)
public class User implements Serializable {

    @Id
    private Integer id;

    // 姓名
    @Field(type = FieldType.Keyword)
    private String name;

    // 爱好
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String hobby;

    // 生日
    @Field(type = FieldType.Date )
    private String birthday;

    // 这里无参构造必须保留,否则反序列化会失败
    public User() {
    }

    public User(Integer id, String name, String hobby, String birthday) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
        this.birthday = birthday;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
