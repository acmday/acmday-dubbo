package com.acmday.dubbo.provider.service.spi;


import com.acmday.dubbo.provider.interfaces.IShout;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang...");
    }
}
