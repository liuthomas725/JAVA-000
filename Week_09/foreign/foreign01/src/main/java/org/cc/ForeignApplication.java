package org.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ForeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForeignApplication.class,args);
    }
}
