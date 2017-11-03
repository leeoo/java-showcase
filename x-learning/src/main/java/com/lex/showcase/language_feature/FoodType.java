package com.lex.showcase.language_feature;

/**
 * 食物类型枚举
 * @author Lex Li
 */
public enum FoodType {
    FRUIT("Fruit", "水果"),
    DRIED_FRUIT("Dried_Fruit", "干果"),
    VEGITABLE("Vegitable", "蔬菜"),
    MEAT("Meat", "肉");

    private String key;
    private String label;

    FoodType(String key, String label) {
        this.key = key;
        this.label = label;
    }
}
