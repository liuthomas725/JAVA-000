package com.example.demo.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @JmsListener(destination = "test")
    public void processMessage(String message){
        System.out.println(message);
    }
}
