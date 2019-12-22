package com.rjf.web;


import com.rjf.pojo.User;
import com.rjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService){
        this.userService=userService;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Resouce lost >.<")
    @ExceptionHandler(Exception.class)
    public void notFound(){
    }

    @GetMapping("/")
    public Flux<User> list(){
        return this.userService.list();
    }

    @GetMapping("/getById/{id}")
    public Mono<User> getById(@PathVariable("id") final String id){
        return this.userService.getById(id);
    }



}
