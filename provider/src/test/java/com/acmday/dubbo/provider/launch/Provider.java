package com.acmday.dubbo.provider.launch;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.acmday.dubbo.provider.BaseClass;
import com.acmday.dubbo.provider.config.AnnotationEchoProviderConf;
import com.acmday.dubbo.provider.service.impl.EchoServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author acmday.
 * @date 2019/11/18.
 */
public class Provider extends BaseClass {

    @Test
    public void anno () {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AnnotationEchoProviderConf.class
        );
        context.start();
        System.out.println("api-echo-provider is running!");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void api() {
        ServiceConfig<IEchoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("api-echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2182"));
        service.setInterface(IEchoService.class);
        service.setRef(new EchoServiceImpl());
        service.export();
        System.out.println("api-echo-provider is running!");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/echo-provider.xml"}
        );
        context.start();
        System.out.println("api-echo-provider is running!");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
