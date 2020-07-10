package com.acmday.dubbo.provider.service;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author acmday.
 * @date 2020/7/10.
 *
 * Dubbo 会为拓展接口生成具有代理功能的代码。然后通过 javassist 或 jdk 编译这段代码，得到 Class 类。最后再通过反射创建代理类...
 * 下面这个类就是为IDubboAdaptive的拓展接口生成的代理类.
 * 参考：http://dubbo.apache.org/zh-cn/docs/source_code_guide/adaptive-extension.html
 *
 * 代理类生成过程逻辑比较多，当前测试方法没用上的逻辑折叠起来 阅读会顺畅些.
 */
public class IDubboAdaptive$Adaptive implements com.acmday.dubbo.provider.service.IDubboAdaptive {
    public java.lang.String echo(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
        if (arg1 == null) throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = arg1;
        String extName = url.getParameter("v");
        if(extName == null) throw new IllegalStateException("Fail to get extension(com.acmday.dubbo.provider.service.IDubboAdaptive) name from url(" + url.toString() + ") use keys([v])");
        com.acmday.dubbo.provider.service.IDubboAdaptive extension = (com.acmday.dubbo.provider.service.IDubboAdaptive)ExtensionLoader.getExtensionLoader(com.acmday.dubbo.provider.service.IDubboAdaptive.class).getExtension(extName);
        return extension.echo(arg0, arg1);
    }
}
    /*
    @Test
    public void dubboAdaptive() {
        URL url = URL.valueOf("acmday://localhost/test?v=spring");
        ExtensionLoader<IDubboAdaptive> extExtensionLoader = ExtensionLoader.getExtensionLoader(IDubboAdaptive.class);
        IDubboAdaptive adaptiveExt = extExtensionLoader.getAdaptiveExtension();
        System.out.println(adaptiveExt.echo("hello", url));
    }
    */