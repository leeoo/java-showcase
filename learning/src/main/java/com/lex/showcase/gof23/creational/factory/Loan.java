package com.lex.showcase.gof23.creational.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lex on 2016/10/29.
 */
public class Loan implements Asset {
    private String name;
    private String cusip;
    private Double price;

    public Loan() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
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
        return buf.append(name).append(".").append(cusip).append(".").append(price).toString();
    }

    @Override
    public Map<String, Object> getMetadata() {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("name", name);
        metadata.put("cusip", cusip);
        metadata.put("price", price);
        return metadata;
    }
}
