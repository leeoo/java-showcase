package com.lex.showcase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 《spring 4.x 企业应用开发实战》第4章 例子
 * @author Lex Li
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {

        // 通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass(("com.lex.showcase.reflect.Car"));

        // 获取类的默认构造器对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor(null);
        Car car = (Car) cons.newInstance();

        // 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
