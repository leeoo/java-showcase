package com.lex.showcase.class_loader;

/**
 * @author Lex Li
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader: " + loader);
        System.out.println("parent loader: " + loader.getParent());
        System.out.println("grandparent loader: " + loader.getParent().getParent());


        try {
            Class clazz = loader.loadClass("com.lex.showcase.class_loader.PrivateCar");
            PrivateCar car = (PrivateCar) clazz.newInstance();
            car.setName("Audi A6");
            car.setBrand("Audi");
            car.setSpeed(100.0);

            car.introduce();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
