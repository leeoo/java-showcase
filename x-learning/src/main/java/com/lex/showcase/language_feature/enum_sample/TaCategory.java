package com.lex.showcase.language_feature.enum_sample;

public enum TaCategory {
    DIRECT("直销"), OTC("中证"), HIGHEND("高端"), FDS("代销"), MFT0("货基T+0");

    private String label;

    TaCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

