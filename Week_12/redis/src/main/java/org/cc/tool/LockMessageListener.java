package org.cc.tool;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.LockSupport;

@Component
public class LockMessageListener {

    public void handleMessage(String message){
        System.out.println("收到消息:" + message);
        LockSupport.unpark(Thread.currentThread());
    }
}
