package org.cc.shardingsphere;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Slf4j
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "datasources.master")
    public DataSource master(){
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasources.slave0")
    public DataSource slave(){
        return new DruidDataSource();
    }

    @Bean
    public DataSource dataSource() {
        // 配置真实数据源

        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("master",master());
        dataSourceMap.put("slave",slave());
        MasterSlaveRuleConfiguration masterSlaveRuleConfiguration = new MasterSlaveRuleConfiguration("datasource","master", Arrays.asList("slave"));
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.setMasterSlaveRuleConfigs(Arrays.asList(masterSlaveRuleConfiguration));
        try {
            return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig,
                    new Properties());
        } catch (SQLException e) {
            e.printStackTrace();
            return master();
        }
    }
}
