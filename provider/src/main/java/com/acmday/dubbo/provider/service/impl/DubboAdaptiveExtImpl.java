package com.acmday.dubbo.provider.service.impl;

import com.acmday.dubbo.provider.service.IDubboAdaptive;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

/**
 * @author acmday.
 * @date 2020/7/4.
 */
//@Adaptive
public class DubboAdaptiveExtImpl implements IDubboAdaptive {

    @Override
    public String echo(String msg, URL url) {
        return "Dubbo";
    }
}
