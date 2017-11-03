package com.lex.showcase.language_feature;

/**
 * @author Lex Li
 */
public class ChineseFood {

    @Food(FoodType.DRIED_FRUIT)
    private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
