package com.acmday.dubbo.provider.spi;

import com.acmday.dubbo.provider.BaseClass;
import com.acmday.dubbo.provider.interfaces.IBook;
import com.acmday.dubbo.provider.interfaces.IShout;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author acmday.
 * @date 2020/6/28.
 */
public class Spi extends BaseClass {

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
