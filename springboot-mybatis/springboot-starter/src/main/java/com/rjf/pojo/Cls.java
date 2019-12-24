package com.rjf.pojo;

import java.util.List;

public class Cls {

    private Integer cid;
    private String cname;
    private String monitor;

    private List<Student> students;

    public Cls() {
    }

    public Cls(Integer cid, String cname, String monitor, List<Student> students) {
        this.cid = cid;
        this.cname = cname;
        this.monitor = monitor;
        this.students = students;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
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
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", monitor='" + monitor + '\'' +
                ", students=" + students +
                '}';
    }
}
