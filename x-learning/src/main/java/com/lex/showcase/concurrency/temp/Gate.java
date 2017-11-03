package com.lex.showcase.concurrency.temp;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Lex Li
 */
public class Gate {
    private int counter;
    private String name;
    private String address;

    public Gate() {

    }

    public Gate(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public synchronized boolean pass(String name, String address) {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter++;
        this.name = name;
        this.address = address;
        check();
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("counter", counter)
                .append("name", name)
                .append("address", address)
                .toString();
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("************BROKE************" + toString());
        }
    }
}
