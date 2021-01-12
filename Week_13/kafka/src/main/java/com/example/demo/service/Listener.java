package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @KafkaListener(topics  = "test")
    public void processMessage(String message){
        System.out.println(message);
    }
}
