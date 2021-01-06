package org.cc.tool;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;

@Component
public class RedisLock {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;

    public void lock(String key){
        while(true){
            String lockVal = valueOperations.get(key);
            System.out.println("lockVal:" + lockVal);
            if(!Objects.isNull(lockVal) && Boolean.valueOf(lockVal)){
                System.out.println("尝试获取锁");
            }else{
                valueOperations.set(key , Boolean.TRUE.toString());
                return;
            }
        }
    }

    public void unlock(String key){
        valueOperations.set(key, Boolean.FALSE.toString());
    }

    public void count(String key){
        String locaKey = key + UUID.randomUUID();
        this.lock(locaKey);
        Integer num = Integer.valueOf(valueOperations.get(key)) -1;
        valueOperations.set(key,num.toString());
        this.unlock(key);
    }
}
