package com.acmday.dubbo.provider.launch;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.acmday.dubbo.provider.service.impl.EchoServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class ApiEchoProvider {
    public static void main(String[] args) throws IOException {
        ServiceConfig<IEchoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("api-echo-provider"));
        service.setRegistry(new RegistryConfig("nacos://127.0.0.1:8848"));
        service.setInterface(IEchoService.class);
        service.setRef(new EchoServiceImpl());
        service.export();
        System.out.println("api-echo-provider is running");
        System.in.read();
    }
}
