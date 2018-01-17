package com.lex.showcase.rule_engine.easy_rule.mobile;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 手机账户Fact
 *
 * @author Lex Li
 */
public class MobileAccount {
    private String mobileNo;
    private String username;

    /**
     * 话费余额
     */
    private BigDecimal balance;

    /**
     * 是否新开户
     */
    private boolean newOpen;
    /**
     * 充值次数（TODO 应该与具体的时间段有关）
     */
    private int topUpTimes;

    /**
     * 当月充值总金额
     */
    private BigDecimal topUpAmountCurrentMonth = BigDecimal.ZERO;

    /**
     * 当季充值总金额
     */
    private BigDecimal topUpAmountCurrentSeason = BigDecimal.ZERO;

    /**
     * 当前半年充值总金额
     */
    private BigDecimal topUpAmountCurrentHalfYear = BigDecimal.ZERO;

    /**
     * 当年充值总金额
     */
    private BigDecimal topUpAmountCurrentYear = BigDecimal.ZERO;

    public MobileAccount() {

    }

    public MobileAccount(String mobileNo, String username, BigDecimal balance, boolean newOpen) {
        this.mobileNo = mobileNo;
        this.username = username;
        this.balance = balance;
        this.newOpen = newOpen;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isNewOpen() {
        return newOpen;
    }

    public void setNewOpen(boolean newOpen) {
        this.newOpen = newOpen;
    }

    public BigDecimal getTopUpAmountCurrentMonth() {
        return topUpAmountCurrentMonth;
    }

    public void setTopUpAmountCurrentMonth(BigDecimal topUpAmountCurrentMonth) {
        this.topUpAmountCurrentMonth = topUpAmountCurrentMonth;
    }

    public BigDecimal getTopUpAmountCurrentSeason() {
        return topUpAmountCurrentSeason;
    }

    public void setTopUpAmountCurrentSeason(BigDecimal topUpAmountCurrentSeason) {
        this.topUpAmountCurrentSeason = topUpAmountCurrentSeason;
    }

    public BigDecimal getTopUpAmountCurrentHalfYear() {
        return topUpAmountCurrentHalfYear;
    }

    public void setTopUpAmountCurrentHalfYear(BigDecimal topUpAmountCurrentHalfYear) {
        this.topUpAmountCurrentHalfYear = topUpAmountCurrentHalfYear;
    }

    public BigDecimal getTopUpAmountCurrentYear() {
        return topUpAmountCurrentYear;
    }

    public void setTopUpAmountCurrentYear(BigDecimal topUpAmountCurrentYear) {
        this.topUpAmountCurrentYear = topUpAmountCurrentYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileAccount that = (MobileAccount) o;

        return mobileNo.equals(that.mobileNo);
    }

    @Override
    public int hashCode() {
        return mobileNo.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mobileNo", mobileNo)
                .append("username", username)
                .append("balance", balance)
                .append("newOpen", newOpen)
                .toString();
    }

    public int getTopUpTimes() {
        return topUpTimes;
    }

    public void setTopUpTimes(int topUpTimes) {
        this.topUpTimes = topUpTimes;
    }
}
