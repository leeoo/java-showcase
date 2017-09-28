package com.lex.showcase.serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * Simple utility to serialize/deserialize between JSON and object for Jackson.
 * @author Lex Li
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
        throw new RuntimeException(new IllegalAccessException("Unable to initialize this class!"));
    }

    public static <T> String toJSON(T t) {
        if (t == null) {
            return null;
        }
        try {
            String json = objectMapper.writeValueAsString(t);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to serialize object to json!", e);
        }
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to deserialize json to object!", e);
        }
    }

    public static <T> List<T> parseObject(String json, TypeReference<List<T>> typeReference) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to deserialize json to object!", e);
        }
    }
}
