package org.cc.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource primary(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public MultiDataSource getMultiDataSource(){
        Map<Object, Object> dataSources = new HashMap<>(2);
        dataSources.put("master",primary());
        dataSources.put("slave",slave());
        MultiDataSource multiDataSource = new MultiDataSource();
        multiDataSource.setTargetDataSources(dataSources);
        multiDataSource.setDefaultTargetDataSource(primary());
        return multiDataSource;
    }
}
