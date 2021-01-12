package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Send {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(){
        kafkaTemplate.send("test","hello world");
    }
}
