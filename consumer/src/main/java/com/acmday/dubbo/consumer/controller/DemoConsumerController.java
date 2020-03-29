package com.acmday.dubbo.consumer.controller;

import com.acmday.dubbo.consumer.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author acmday
 * @date 2019/11/18.
 */
@Slf4j
@RestController
public class DemoConsumerController {

    @Autowired
    private EchoService echoService;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        log.info("act=sayHello name={}", name);
        return echoService.echo(name);
    }
}
