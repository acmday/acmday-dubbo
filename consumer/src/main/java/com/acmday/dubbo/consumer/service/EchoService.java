package com.acmday.dubbo.consumer.service;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2019/11/18.
 */
@Component
public class EchoService {
    @Reference
    private IEchoService echoService;

    public String echo(String msg) {
        return echoService.echo(msg);
    }
}
