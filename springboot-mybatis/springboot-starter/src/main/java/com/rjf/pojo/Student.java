package com.rjf.pojo;

public class Student {

    private int id;
    private String name;
    private String password;
    private Integer clsId;
    private Cls cls;

    public Student() {
    }

    public Student(int id, String name, String password, Integer clsId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.clsId = clsId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    public Cls getCls() {
        return cls;
    }

    public void setCls(Cls cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", cls=" + clsId +
                '}';
    }
}
