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
    public void dubboAdaptive() {
        URL url = URL.valueOf("acmday://localhost/test?v=dubbo");
        ExtensionLoader<IDubboAdaptive> extExtensionLoader = ExtensionLoader.getExtensionLoader(IDubboAdaptive.class);
        IDubboAdaptive adaptiveExt = extExtensionLoader.getAdaptiveExtension();
        System.out.println(adaptiveExt.echo("hello", url));
    }

    @Test
    public void adaptive() {
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
