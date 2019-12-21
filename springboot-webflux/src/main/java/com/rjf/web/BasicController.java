package com.rjf.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BasicController {

    @GetMapping("/hello")
    public Mono<String> helloWebFlux(){
        return Mono.just("Hello WebFlux");
    }
}
