package com.acmday.dubbo.provider.jdk;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author acmday.
 * @date 2020/7/30.
 */
public class JavassistTest {

    @Test
    public void helloWorld() {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("HelloWorld");
        try {
            CtMethod ctMethod = CtNewMethod.make("public void test(String message) {\n" +
                    "        System.out.println(message);\n" +
                    "    }", ctClass);
            ctClass.addMethod(ctMethod);
            Class aClass = ctClass.toClass();

            Object ob = aClass.newInstance();
            Method method = aClass.getDeclaredMethod("test", String.class);
            method.invoke(ob, "Hello World, acmday!");

        } catch (CannotCompileException | IllegalAccessException | InstantiationException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
