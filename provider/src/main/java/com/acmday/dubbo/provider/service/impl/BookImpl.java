package com.acmday.dubbo.provider.service.impl;

import com.acmday.dubbo.provider.interfaces.IBook;

/**
 * @author acmday.
 * @date 2020/3/31.
 */
public class BookImpl implements IBook {
    @Override
    public void printBookName() {
        System.out.println("Thinking in Java...");
    }
}
