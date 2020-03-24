package com.rjf.mybatis.quickstart.pojo;

import com.rjf.mybatis.quickstart.common.BaseResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentResult extends BaseResult {

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}