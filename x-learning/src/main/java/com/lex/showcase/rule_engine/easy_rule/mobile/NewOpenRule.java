package com.lex.showcase.rule_engine.easy_rule.mobile;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.math.BigDecimal;

/**
 * 新开户手机用户规则 - 对于新开户的手机用户送20元话费。
 * @author Lex Li
 */
@Rule(name = "NewOpenRule", description = "New open rule")
public class NewOpenRule {
    @Condition
    public boolean isNewUser(@Fact("newOpenFact") MobileAccount mobileAccount) {
        return mobileAccount != null && mobileAccount.isNewOpen();
    }

    /**
     * 操作1：送20元话费
     * @param mobileAccount
     */
    @Action(order = 0)
    public void recharge20(@Fact("newOpenFact") MobileAccount mobileAccount) {
        System.out.println("新开户用户，送20元话费。");
        BigDecimal oldBalance = mobileAccount.getBalance();
        mobileAccount.setBalance(mobileAccount.getBalance().add(new BigDecimal(20.0)));
//        mobileAccount.setNewOpen(false); // TODO 抽出为一个单独的操作？
        System.out.println(String.format("用户话费余额：赠送前=%s，赠送后=%s。", oldBalance, mobileAccount.getBalance()));
    }

    /**
     * 操作2：将新开户状态关闭
     * @param mobileAccount
     */
    @Action(order = 1)
    public void closeNewOpenStatus(@Fact("newOpenFact") MobileAccount mobileAccount) {
        mobileAccount.setNewOpen(false);
    }





}
