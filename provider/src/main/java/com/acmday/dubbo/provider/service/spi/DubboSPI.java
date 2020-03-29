package com.acmday.dubbo.provider.service.spi;

import com.acmday.dubbo.provider.interfaces.IShout;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class DubboSPI {
    public static void main(String[] args) {
        ExtensionLoader<IShout> extensionLoader = ExtensionLoader.getExtensionLoader(IShout.class);
        IShout cat = extensionLoader.getExtension("cat");
        cat.shout();
        IShout dog = extensionLoader.getExtension("dog");
        dog.shout();
    }
}
