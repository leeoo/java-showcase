package com.lex.showcase.gof23.creational.factory;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class Bond implements Asset {
    private String name;
    private String isin;
    private Double price;

    public Bond() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String generateKey() {
        StringBuffer buf = new StringBuffer();
        return buf.append(name).append(".").append(isin).append(".").append(price).toString();
    }

    @Override
    public Map<String, Object> getMetadata() {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("name", name);
        metadata.put("isin", isin);
        metadata.put("price", price);
        return metadata;
    }
}
