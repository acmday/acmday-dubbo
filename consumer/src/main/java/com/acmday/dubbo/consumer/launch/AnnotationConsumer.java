package com.acmday.dubbo.consumer.launch;

import com.acmday.dubbo.consumer.config.AnnotationEchoConsumerConf;
import com.acmday.dubbo.consumer.service.EchoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class AnnotationConsumer {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AnnotationEchoConsumerConf.class
        );
        context.start();
        EchoService echoService = context.getBean(EchoService.class);
        String hello = echoService.echo("acmday");
        System.err.println("annotation-echo-provider result:\n" + hello + "\n");
        System.in.read();
    }
}
