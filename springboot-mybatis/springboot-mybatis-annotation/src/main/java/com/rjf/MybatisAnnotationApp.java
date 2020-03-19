package com.rjf;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rjf.mapper")
public class MybatisAnnotationApp {

    public static void main(String[] args){
        SpringApplication.run(MybatisAnnotationApp.class,args);
    }

}
