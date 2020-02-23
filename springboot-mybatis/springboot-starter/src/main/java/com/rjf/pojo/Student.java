package com.rjf.pojo;

import java.util.Date;

public class Student {

    private Integer stuId;
    private String stuName;
    private String password;
    private Date birthday;

    //逻辑外键
    private Integer clsId;

    public Student() {
    }

    public Student(Integer stuId, String stuName, String password, Date birthday, Integer clsId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.password = password;
        this.birthday = birthday;
        this.clsId = clsId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", clsId=" + clsId +
                '}';
    }
}
