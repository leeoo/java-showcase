package com.lex.showcase.gof23.creational.builder;

/**
 * @author Lex Li
 * 准备实体、
 */
public class RemarkBuilder<T> {
    private T t;

    public RemarkBuilder(T t) {
        this.t = t;
    }

    public RemarkBuilder append(T t) {

        return this;
    }

    public String toRemark() {
        return this.toString();
    }

    public static void main(String[] args) {
        String remark = String.format("");
    }
}
