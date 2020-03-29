package com.acmday.dubbo.provider.launch;

import com.acmday.dubbo.provider.config.AnnotationEchoProviderConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author acmday.
 * @date 2019/11/18.
 */
public class AnnotationEchoProvider {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AnnotationEchoProviderConf.class
        );
        context.start();
        System.in.read();
    }
}
