package com.lex.showcase.gof23.creational.factory;

/**
 *
 */
public interface AssetFactory {
    <T>  T getBean(Class<T> clazz) throws Exception;
}
