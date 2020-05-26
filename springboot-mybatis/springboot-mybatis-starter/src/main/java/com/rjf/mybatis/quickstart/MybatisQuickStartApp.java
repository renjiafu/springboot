package com.rjf.mybatis.quickstart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MybatisQuickStartApp {

    public static void main(String[] args){
        SpringApplication.run(MybatisQuickStartApp.class,args);
    }

}
