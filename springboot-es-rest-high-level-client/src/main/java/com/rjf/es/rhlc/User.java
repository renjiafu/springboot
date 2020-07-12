package com.rjf.es.rhlc;

/*
 *
 *   Rene
 *   2020/7/12 11:31
 */

import java.util.Date;

public class User  {

    // 主键
    private Long id;

    // 名字
    private String name;

    // 国家
    private String country;

    // 生日
    private Date birthday;

    // 描述
    private String des;

    public User() {
    }

    public User(Long id, String name, String country, Date birthday, String des) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.des = des;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", des='" + des + '\'' +
                '}';
    }
}
