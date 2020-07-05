package com.acmday.dubbo.provider.service;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author acmday.
 * @date 2020/7/4.
 */
@SPI
public interface IEchoAdaptiveExt {
    String echo(String msg, URL url);
}
