package com.acmday.dubbo.provider.jdk;

import com.acmday.dubbo.provider.BaseClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author acmday.
 * @date 2020/6/30.
 */
@Slf4j
public class ClassLoaderTest extends BaseClass {

    private static final String PREFIX = "META-INF/services/";
    private static final String INTERFACES = "com.acmday.dubbo.provider.service.IBook";

    @Test
    public void getResource() {

        URL u = getUrlByResources();
        InputStream in = null;
        BufferedReader r = null;

        try {
            in = u.openStream();
            r = new BufferedReader(new InputStreamReader(in, "utf-8"));

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
