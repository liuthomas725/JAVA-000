package org.cc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
public class ForeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForeignApplication.class,args);
    }
}
