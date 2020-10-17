package com.rjf.mybatis.model;

public class Student {

    private Integer stuId;
    private String stuName;
    private Integer stuAge;


    public Student() {
    }

    public Student(Integer stuId, String stuName, Integer stuAge) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    public Integer getId() {
        return stuId;
    }

    public void setId(Integer stuId) {
        this.stuId = stuId;
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
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
