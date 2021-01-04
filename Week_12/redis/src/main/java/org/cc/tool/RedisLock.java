package org.cc.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.locks.LockSupport;

@Component
public class RedisLock {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;

    public void lock(String key){
        if(redisTemplate.){

        }
        LockSupport.park();
    }
}
