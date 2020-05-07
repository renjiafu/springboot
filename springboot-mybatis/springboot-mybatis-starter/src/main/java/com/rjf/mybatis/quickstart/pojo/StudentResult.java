package com.rjf.mybatis.quickstart.pojo;

import com.rjf.mybatis.quickstart.common.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentResult extends Result {

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
