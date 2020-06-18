package com.rjf.mybatis.web;

/*
 *
 *   Rene
 *   2020/5/26 21:28
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/sign-in")
    public String signIn(HttpSession session){
        session.setAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return "signIn";
    }


    @GetMapping("/sign-out")
    public String signOut(HttpSession session){
        session.invalidate();
        return "signOut";
    }


    @GetMapping("/sign-up")
    public String signUp(){
        return "signUp";
    }

}
