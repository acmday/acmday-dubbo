package com.acmday.dubbo.provider.service.impl;

import com.acmday.dubbo.provider.service.IEchoAdaptiveExt;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import lombok.extern.slf4j.Slf4j;

/**
 * @author acmday.
 * @date 2020/7/4.
 */
@Slf4j
public class EchoAdaptiveExtImpl implements IEchoAdaptiveExt {

    @Override
    public String echo(String msg, URL url) {
        log.info("act=echo msg={}, protocol={}", msg, url.getProtocol());
        return "Spring";
    }
}
