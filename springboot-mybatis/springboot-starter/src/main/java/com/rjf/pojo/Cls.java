package com.rjf.pojo;

import java.util.List;

public class Cls {

    private int id;
    private String clsName;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Cls{" +
                "id=" + id +
                ", clsName='" + clsName + '\'' +
                '}';
    }
}
