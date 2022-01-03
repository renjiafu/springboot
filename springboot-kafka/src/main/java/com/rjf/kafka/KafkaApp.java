package com.rjf.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KafkaApp {

    @Autowired
    MesService mesService;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class);
    }

    @GetMapping("/send/{msg}")
    public void sendMessage(@PathVariable("msg") String msg) throws Exception {
        mesService.send(msg);
    }
}
