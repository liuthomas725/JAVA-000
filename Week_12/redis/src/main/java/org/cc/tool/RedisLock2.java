package org.cc.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;

@Component
public class RedisLock2 {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired
    private LockMessageListener lockMessageListener;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(connectionFactory);
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(lockMessageListener,"handleMessage");
        messageListenerAdapter.afterPropertiesSet();
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,new PatternTopic("*Lock"));
        return redisMessageListenerContainer;
    }

    public void lock(String key){
        if(redisTemplate.hasKey(key)){
            LockSupport.park();
        }else{
            valueOperations.set(key, UUID.randomUUID().toString());
        }
    }

    public void unlock(String key){
        redisTemplate.delete(key);
        redisTemplate.convertAndSend(key + "Lock",Boolean.FALSE.toString());
    }
}
