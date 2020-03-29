package com.acmday.dubbo.provider.launch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class XmlEchoProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/echo-provider.xml"}
        );
        context.start();
        System.in.read();
    }
}
