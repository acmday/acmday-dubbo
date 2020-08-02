package com.acmday.dubbo.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author acmday.
 * @date 2020/8/2.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        String hello = "----hello!----";
        System.out.println(hello);
        return hello;
    }
}
