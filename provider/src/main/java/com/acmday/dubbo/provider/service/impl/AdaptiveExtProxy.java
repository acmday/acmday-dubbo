package com.acmday.dubbo.provider.service.impl;

import com.acmday.dubbo.provider.service.IEchoAdaptiveExt;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author acmday.
 * @date 2020/7/4.
 */
public class AdaptiveExtProxy implements IEchoAdaptiveExt {
    @Override
    public String echo(String msg, URL url) {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }

        // 从 URL 中获取 AdaptiveExt 名称
        String name = url.getParameter("adaptive.ext");
        if (name == null ) {
            throw new IllegalArgumentException("name == null");
        }

        // 调用 SPI 动态加载具体的 AdaptiveExt
        IEchoAdaptiveExt adaptiveExt = ExtensionLoader
                .getExtensionLoader(IEchoAdaptiveExt.class)
                .getExtension(name);

        // 调用具体的方法
        return adaptiveExt.echo(msg, url);
    }
}
