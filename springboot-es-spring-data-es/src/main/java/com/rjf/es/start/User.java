package com.rjf.es.start;

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

    // 班级
    @Field(type = FieldType.Keyword)
    private String cls;

    // 生日
    @Field(type = FieldType.Keyword)
    private String birthday;

    // 爱好
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String hobby;


    // 这里无参构造必须保留,否则反序列化会失败
    public User() {
    }

    public User(Integer id, String name, String cls, String hobby, String birthday) {
        this.id = id;
        this.name = name;
        this.cls = cls;
        this.birthday = birthday;
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

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cls='" + cls + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
