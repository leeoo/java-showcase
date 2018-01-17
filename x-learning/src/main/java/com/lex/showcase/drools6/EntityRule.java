package com.lex.showcase.drools6;

import java.util.UUID;

/**
 * @author Lex Li
 */
public class EntityRule {

    private String username;

    /**
     * Whether for new account.
     */
    private boolean account;

    /**
     * The number of add.
     */
    private int addtime;
    /**
     * The sum of the current account.
     */
    private double currentmoney;
    /**
     * The total amount added.
     */
    private double totaladdmoney;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccount() {
        return account;
    }

    public void setAccount(boolean account) {
        this.account = account;
    }

    public int getAddtime() {
        return addtime;
    }

    public void setAddtime(int addtime) {
        this.addtime = addtime;
    }

    public double getCurrentmoney() {
        return currentmoney;
    }

    public void setCurrentmoney(double currentmoney) {
        this.currentmoney = currentmoney;
    }

    public double getTotaladdmoney() {
        return totaladdmoney;
    }

    public void setTotaladdmoney(double totaladdmoney) {
        this.totaladdmoney = totaladdmoney;
    }

    public void getSerialnumber(String username, double currentmoney) {
        System.out.println("Account: " + username + " Balance: $" + currentmoney);
        System.out.println("Serial Number: " + UUID.randomUUID().toString());
    }
}
