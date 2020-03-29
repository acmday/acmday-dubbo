package com.acmday.dubbo.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author acmday
 * @date 2019/11/18.
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.acmday.dubbo.provider")
public class AnnotationEchoProviderConf {
    @Bean
    public AnnotationEchoProviderConf providerConf(){
        return new AnnotationEchoProviderConf();
    }

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("annotation-echo-provider");
        applicationConfig.setQosAcceptForeignIp(false);
        applicationConfig.setQosEnable(true);
        applicationConfig.setQosPort(33333);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("nacos");
        registryConfig.setAddress("localhost");
        registryConfig.setPort(8848);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }
}
