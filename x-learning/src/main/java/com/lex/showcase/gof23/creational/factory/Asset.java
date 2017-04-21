package com.lex.showcase.gof23.creational.factory;

import java.util.Map;

/**
 *
 */
public interface Asset {
    String generateKey();

    Map<String, Object> getMetadata();
}
