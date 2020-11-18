package org.cc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "org.cc",name="enabled",havingValue = "true")
@EnableConfigurationProperties(StudentConfig.class)
public class TestAutoConfig {
    @Autowired
    private StudentConfig studentConfig;

    @Bean("student")
    public Student getStudent(){
        return new Student(studentConfig.getName(),studentConfig.getAge());
    }
}
