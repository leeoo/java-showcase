package com.lex.showcase.multiple_datasource.datasource;

public enum DataSourcePolicy {

    MASTER("master"),

    SLAVE("slave"),;

    private String name;

    DataSourcePolicy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
