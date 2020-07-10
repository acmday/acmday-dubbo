package com.acmday.dubbo.provider.spi;

import com.acmday.dubbo.provider.BaseClass;
import com.acmday.dubbo.provider.service.IBook;
import com.acmday.dubbo.provider.service.IDubboAdaptive;
import com.acmday.dubbo.provider.service.IEchoAdaptiveExt;
import com.acmday.dubbo.provider.service.IShout;
import com.acmday.dubbo.provider.service.impl.AdaptiveExtProxy;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author acmday.
 * @date 2020/6/28.
 */
public class Spi extends BaseClass {

    @Test
    public void f() {

        first:
            for (int i=0; i<10; ++i) {
                System.out.println("----first");
                if(i == 5){
                    break first;
                }
            }
        System.out.println("over");
    }

    /**
     * 优先级 @Adaptive标注在类上 > URL > SPI的value
     */
    @Test
    public void dubboAdaptive() {
        // URL url = URL.valueOf("acmday://localhost/test");
        URL url = URL.valueOf("acmday://localhost/test?v=spring");
        ExtensionLoader<IDubboAdaptive> extExtensionLoader = ExtensionLoader.getExtensionLoader(IDubboAdaptive.class);
        IDubboAdaptive adaptiveExt = extExtensionLoader.getAdaptiveExtension();
        System.out.println(adaptiveExt.echo("hello", url));
    }

    @Test
    public void myAdaptive() {
        URL url = URL.valueOf("acmday://localhost/test?adaptive.ext=spring");
        IEchoAdaptiveExt iEchoAdaptiveExt = new AdaptiveExtProxy();
        System.out.println(iEchoAdaptiveExt.echo("hello", url));
    }

    @Test
    public void dubboSpi() {
        ExtensionLoader<IShout> extensionLoader = ExtensionLoader.getExtensionLoader(IShout.class);
        IShout cat = extensionLoader.getExtension("cat");
        cat.shout();
        IShout dog = extensionLoader.getExtension("dog");
        dog.shout();
    }

    @Test
    public void javaSpi() {
        ServiceLoader<IBook> book = ServiceLoader.load(IBook.class);
        book.forEach(IBook::printBookName);
    }
}
