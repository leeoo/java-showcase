package com.lex.showcase.concurrency.temp;

/**
 * @author Lex Li
 */
public class UserThread extends Thread {
    private String username;
    private String address;

    private Gate gate;


    public UserThread(String username, String address, Gate gate) {
        this.username = username;
        this.address = address;
        this.gate = gate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(username + "-----BEGIN-----");
        while (true) {
            gate.pass(username, address);
        }
    }
}
