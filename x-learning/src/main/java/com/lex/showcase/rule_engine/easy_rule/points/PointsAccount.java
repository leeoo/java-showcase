package com.lex.showcase.rule_engine.easy_rule.points;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author Lex Li
 */
public class PointsAccount {
    private String custNo;
    private String tradeAcco;
    private String bankCardNo;
    private BigDecimal pointsAmount;

    public PointsAccount() {

    }

    public PointsAccount(String custNo, String tradeAcco, String bankCardNo, BigDecimal pointsAmount) {
        this.custNo = custNo;
        this.tradeAcco = tradeAcco;
        this.bankCardNo = bankCardNo;
        this.pointsAmount = pointsAmount;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getTradeAcco() {
        return tradeAcco;
    }

    public void setTradeAcco(String tradeAcco) {
        this.tradeAcco = tradeAcco;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public BigDecimal getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(BigDecimal pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("custNo", custNo)
                .append("tradeAcco", tradeAcco)
                .append("bankCardNo", bankCardNo)
                .append("pointsAmount", pointsAmount)
                .toString();
    }
}
