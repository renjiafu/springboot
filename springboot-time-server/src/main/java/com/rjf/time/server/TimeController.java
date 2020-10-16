package com.rjf.time.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TimeController {

    @GetMapping("/")
    public String getTime(){
        return LocalDateTime.now().toString();
    }
}
