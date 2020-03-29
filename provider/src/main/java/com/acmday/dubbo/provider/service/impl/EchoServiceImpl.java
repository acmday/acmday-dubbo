package com.acmday.dubbo.provider.service.impl;

import com.acmday.dubbo.api.interfaces.IEchoService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author acmday.
 * @date 2019/11/18.
 */
@Slf4j
@Service
public class EchoServiceImpl implements IEchoService {

    @Override
    public String echo(String message) {
        return "message:" + message + ", address=" + RpcContext.getContext().getRemoteAddress();
    }
}
