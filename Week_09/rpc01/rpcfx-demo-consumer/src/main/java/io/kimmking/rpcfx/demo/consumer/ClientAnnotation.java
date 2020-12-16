package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.annotation.Rpc;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

public class ClientAnnotation implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent()==null){
            Map<String,Object> beans = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(Rpc.class);
            for(Object bean : beans.values()){
                Rpc ca = bean.getClass().getAnnotation(Rpc.class);
            }
        }
    }
}
