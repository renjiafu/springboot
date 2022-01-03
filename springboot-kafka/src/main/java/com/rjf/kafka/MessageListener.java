package com.rjf.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@KafkaListener(topics = "topic-001", groupId = "test-consumer-rjf")
public class MessageListener {

    @KafkaHandler
    public void receiver(String mes){
        log.info("consumer receive --> ",mes);
    }
}
