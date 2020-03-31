package com.acmday.dubbo.provider.service.impl;

import com.acmday.dubbo.provider.interfaces.IShout;

/**
 * @author acmday
 * @date 2019/11/18.
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao...");
    }
}
