package com.acmday.dubbo.provider.interfaces;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author acmday
 * @date 2019/11/18.
 */
@SPI
public interface IShout {
    void shout();
}
