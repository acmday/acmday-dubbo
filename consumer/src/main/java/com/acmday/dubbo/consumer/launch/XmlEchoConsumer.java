package com.acmday.dubbo.consumer.launch;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.acmday.dubbo.consumer.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author acmday
 * @date 2019/11/18.
 */
@Slf4j
public class XmlEchoConsumer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/echo-consumer.xml"}
        );
        context.start();

        IEchoService echoService = (IEchoService) context.getBean("echoService");
        String res = echoService.echo("acmday");

        System.err.println("xml-echo-consumer result:\n" + res + "\n");
        System.in.read();
    }
}
