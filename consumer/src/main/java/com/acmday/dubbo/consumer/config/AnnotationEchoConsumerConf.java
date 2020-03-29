package com.acmday.dubbo.consumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author acmday
 * @date 2019/11/18.
 */
@Configuration
@EnableDubbo(scanBasePackageClasses = com.acmday.dubbo.consumer.service.EchoService.class)
@ComponentScan(basePackageClasses = com.acmday.dubbo.consumer.service.EchoService.class)
public class AnnotationEchoConsumerConf {
    @Bean
    public AnnotationEchoConsumerConf consumerConf() {
        return new AnnotationEchoConsumerConf();
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("annotation-echo-consumer");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("nacos");
        registryConfig.setAddress("localhost");
        registryConfig.setPort(8848);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }
}
