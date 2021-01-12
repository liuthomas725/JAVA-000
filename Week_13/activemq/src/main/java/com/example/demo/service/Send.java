package com.example.demo.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Send {
    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMessage(){
        jmsTemplate.convertAndSend("test","hello world");
    }
}
