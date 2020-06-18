package com.rjf.aop.web;

import com.rjf.aop.log.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @GetMapping("/test")
    @Log
    public String test(){
        return "测试aop";
    }
}
