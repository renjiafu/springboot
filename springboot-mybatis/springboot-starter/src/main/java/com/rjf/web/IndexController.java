package com.rjf.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

        @GetMapping("/")
        public String index(){
            return "<html><h1>您好 !<h/></html>";
        }

}
