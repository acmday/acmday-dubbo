package com.acmday.dubbo.consumer.launch;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.acmday.dubbo.consumer.BaseClass;
import com.acmday.dubbo.consumer.config.AnnotationEchoConsumerConf;
import com.acmday.dubbo.consumer.service.EchoService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author acmday.
 * @date 2020/6/29.
 */
public class Consumer extends BaseClass {

    @Test
    public void anno() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AnnotationEchoConsumerConf.class
        );
        context.start();
        EchoService echoService = context.getBean(EchoService.class);
        String hello = echoService.echo("acmday");
        System.out.println("annotation-echo-provider result:\n" + hello + "\n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void api() {
        ReferenceConfig<IEchoService> reference = new ReferenceConfig<IEchoService>();
        reference.setApplication(new ApplicationConfig("api-echo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2182"));
        reference.setInterface(IEchoService.class);
        IEchoService greetingService = reference.get();
        String message = greetingService.echo("acmday");
        System.out.println("api-echo-consumer result:\n" + message + "\n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/echo-consumer.xml"}
        );
        context.start();

        IEchoService echoService = (IEchoService) context.getBean("echoService");
        String res = echoService.echo("acmday");

        System.out.println("xml-echo-consumer result:\n" + res + "\n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
