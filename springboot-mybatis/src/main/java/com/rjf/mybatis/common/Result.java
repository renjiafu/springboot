package com.rjf.mybatis.common;

import org.springframework.stereotype.Component;

@Component
public class Result<T> {

    private String status;
    private String code;
    private String msg;
    private T date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
