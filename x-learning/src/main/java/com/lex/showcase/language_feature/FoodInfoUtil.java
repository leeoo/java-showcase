package com.lex.showcase.language_feature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author Lex Li
 */
public class FoodInfoUtil {
    private static Logger log = LoggerFactory.getLogger(FoodInfoUtil.class);
    public static void getFoodInfo(Class<?> clazz) {
        String strFoodType = "食物类型：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Food.class)) {
                Food food = field.getAnnotation(Food.class);
                strFoodType = strFoodType + food.value();
                log.info(strFoodType);
            }
        }
    }
}
