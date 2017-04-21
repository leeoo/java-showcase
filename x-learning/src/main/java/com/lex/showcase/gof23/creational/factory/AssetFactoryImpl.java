package com.lex.showcase.gof23.creational.factory;

/**
 */
public class AssetFactoryImpl implements AssetFactory {
    @Override
    public <T> T getBean(Class<T> clazz) throws Exception {
        return (T) clazz.forName(clazz.getName()).newInstance();
    }
}
