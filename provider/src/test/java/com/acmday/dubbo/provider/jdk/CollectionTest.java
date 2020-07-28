package com.acmday.dubbo.provider.jdk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/7/28.
 */
public class CollectionTest {

    @Test
    public void addAll() {
        List<String> lists = new ArrayList<>();
        lists.add("one");
        lists.add("two");
        lists.add("three");

        System.out.println("before addAll......");
        System.out.println(lists.toString());

        lists.addAll(0, Arrays.asList("1","2","3","4"));
        System.out.println("after addAll......");
        System.out.println(lists.toString());
    }
}
