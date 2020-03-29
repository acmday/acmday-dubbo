package com.acmday.dubbo.provider.service.spi;


import com.acmday.dubbo.provider.interfaces.IShout;

import java.util.ServiceLoader;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class JavaSPI {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        shouts.forEach(IShout::shout);
    }
}
