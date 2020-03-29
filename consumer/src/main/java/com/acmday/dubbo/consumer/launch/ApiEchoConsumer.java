package com.acmday.dubbo.consumer.launch;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.acmday.dubbo.consumer.service.EchoService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import java.io.IOException;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class ApiEchoConsumer {
    public static void main(String[] args) throws IOException {
        ReferenceConfig<IEchoService> reference = new ReferenceConfig<IEchoService>();
        reference.setApplication(new ApplicationConfig("api-echo-consumer"));
        reference.setRegistry(new RegistryConfig("nacos://127.0.0.1:8848"));
        reference.setInterface(IEchoService.class);
        IEchoService greetingService = reference.get();
        String message = greetingService.echo("acmday");
        System.out.println("api-echo-consumer result:\n" + message + "\n");
        System.in.read();
    }
}
