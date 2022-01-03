package com.rjf.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MesService {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void send(String msg) throws Exception{
        kafkaTemplate.send("tpic-001",msg);
    }


}
