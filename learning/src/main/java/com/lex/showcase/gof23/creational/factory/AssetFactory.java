package com.lex.showcase.gof23.creational.factory;

/**
 * Created by Lex on 2016/10/29.
 */
public interface AssetFactory {
    <T>  T getBean(Class<T> clazz) throws Exception;
}
