package com.rjf.aop.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @GetMapping("/test")
    public String test(){
        return "测试aop";
    }
}
