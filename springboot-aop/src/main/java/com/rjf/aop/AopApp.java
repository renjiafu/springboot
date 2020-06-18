package com.rjf.aop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApp {

    public static void main(String[] args) {

        SpringApplication.run(AopApp.class,args);
    }
}
