package com.rjf.mybatis.quickstart.pojo;

public class Student {

    private Integer id;
    private String stuName;
    private Integer stuAge;


    public Student() {
    }

    public Student(Integer id, String stuName, Integer stuAge) {
        this.id = id;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
