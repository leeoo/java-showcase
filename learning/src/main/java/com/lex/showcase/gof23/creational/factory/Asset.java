package com.lex.showcase.gof23.creational.factory;

import java.util.Map;

/**
 * Created by Lex on 2016/10/29.
 */
public interface Asset {
    String generateKey();

    Map<String, Object> getMetadata();
}
