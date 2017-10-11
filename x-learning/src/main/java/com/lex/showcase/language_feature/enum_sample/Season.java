package com.lex.showcase.language_feature.enum_sample;

/**
 * @author Lex Li
 */
public enum Season {
    SPRING("Spring"),
    SUMMER("Summer"),
    AUTUMN("Autumn"),
    WINTER("Winter");

    private String name;

    Season(String name) {
        this.name = name;
    }
}
