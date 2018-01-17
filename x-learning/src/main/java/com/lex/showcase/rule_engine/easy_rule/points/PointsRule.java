package com.lex.showcase.rule_engine.easy_rule.points;

import org.apache.commons.lang.StringUtils;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.math.BigDecimal;

/**
 * @author Lex Li
 */
@Rule(name = "PointsRule", description = "Points Rule")
public class PointsRule {

    @Condition
    public boolean newUserBindsCard(@Fact("pointsAccount") PointsAccount account) {
        return account != null
                && StringUtils.isNotBlank(account.getCustNo())
                && StringUtils.isNotBlank(account.getTradeAcco())
                && StringUtils.isNotBlank(account.getBankCardNo());
    }

    @Action
    public void issueTenPoints(@Fact("pointsAccount") PointsAccount account) {
        System.out.println("新用户注册绑卡，送10积分。");
        BigDecimal oldPointsAmount = account.getPointsAmount();
        account.setPointsAmount(account.getPointsAmount().add(new BigDecimal(10.0)));
        System.out.println(String.format("用户积分：绑卡前=%s，绑卡后=%s。", oldPointsAmount, account.getPointsAmount()));
    }
}
