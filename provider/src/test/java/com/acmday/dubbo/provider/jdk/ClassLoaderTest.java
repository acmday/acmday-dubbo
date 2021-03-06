package com.acmday.dubbo.provider.jdk;

import com.acmday.dubbo.provider.BaseClass;
import com.acmday.dubbo.provider.bo.Rain;
import com.acmday.dubbo.provider.service.IBook;
import com.acmday.dubbo.provider.service.impl.SpringAdaptiveExtImpl;
import com.sun.org.apache.bcel.internal.generic.FADD;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author acmday.
 * @date 2020/6/30.
 */
@Slf4j
public class ClassLoaderTest extends BaseClass {

    private static final String PREFIX = "META-INF/services/";
    private static final String INTERFACES = "com.acmday.dubbo.provider.service.IBook";
    private static final String CLASS_NAME = "com.acmday.dubbo.provider.service.impl.BookImpl";


    @Test
    public void getSetterProperty() {
        log.info("-------------------");
        Arrays.stream(Rain.class.getMethods()).filter(elem -> elem.getName().startsWith("set")).forEach(elem ->{
            log.info(getSetterProperty(elem));
        });
        log.info("-------------------");
    }

    private String getSetterProperty(Method method) {
        return method.getName().length() > 3 ? method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4) : "";
    }

    @Test
    public void getClassByName() {
        try {
            Class clazz = Class.forName(CLASS_NAME, false, Thread.currentThread().getContextClassLoader());
            log.info("act=getClassByName simpleName={} \n methods={}", clazz.getSimpleName(), clazz.getMethods());
        } catch (ClassNotFoundException e) {
            log.error("act=getClassByName e=", e);
        }
    }

    @Test
    public void getResource() {

        URL u = getUrlByResources();
        InputStream in = null;
        BufferedReader r = null;

        try {
            in = u.openStream();
            r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

            log.info("act=getResource content={}", r.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (r != null) r.close();
                if (in != null) in.close();
                //throw new IOException();
            } catch (IOException y) {
                log.error("act=getResource e=", y);
            }
        }
    }

    private URL getUrlBySystemResource() {
        return ClassLoader.getSystemResource(PREFIX + INTERFACES);
    }

    private URL getUrlByResources() {
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(PREFIX + INTERFACES);
            while (resources.hasMoreElements()) {
                //因为是测试，这里就只返回第一个了
                return resources.nextElement();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
