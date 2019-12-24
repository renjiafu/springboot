package com.rjf.pojo;

public class Student {

    private Integer sid;
    private String sname;
    private String password;
    private Integer clsId;
    private Integer grade;

    private Cls cls;

    public Student() {
    }

    public Student(Integer sid, String sname, String password, Integer clsId, Integer grade ) {
        this.sid = sid;
        this.sname = sname;
        this.password = password;
        this.clsId = clsId;
        this.grade = grade;

    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", clsId=" + clsId +
                ", grade=" + grade +
                ", cls=" + cls +
                '}';
    }
}
