package com.lex.showcase.rule_engine.easy_rule.mobile;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

import java.math.BigDecimal;

/**
 * 指定时间段内达到特定充值次数送手机话费规则 - 在2017年10月到12期间充值的用户，不论金额多少充值满3次就赠送5元话费。
 * @author Lex Li
 */
@Rule(name = TopUpTimesInSpecifiedDurationRule.RULE_NAME,
//        name = "TopUpTimesInSpecifiedDurationRule",
        description = "Top up times in specified duration rule")
public class TopUpTimesInSpecifiedDurationRule {
    public static final String RULE_NAME = "TopUpTimesInSpecifiedDurationRule";


    // TODO 可变规则参数 （在数据库里配置：key=TOP_UP_WHEN_REACH_3_TIMES_THEN_PRESENT_3_MONEY, top_up_times=3, prensent_amount=3）
    private static final int SPECIFIED_TOP_UP_TIMES = 3;
    private static final BigDecimal PRESENT_AMOUNT = new BigDecimal(5);

    @Condition
    public boolean when(@Fact("topUpTimesInSpecifiedDurationFact") MobileAccount account) {
        return account != null && account.getTopUpTimes() >= SPECIFIED_TOP_UP_TIMES;
    }

    /**
     * @param account
     */
    @Action
    public void then(@Fact("topUpTimesInSpecifiedDurationFact") MobileAccount account) {
        BigDecimal oldBalance = account.getBalance();
        account.setBalance(account.getBalance().add(PRESENT_AMOUNT));
        BigDecimal newBalance = account.getBalance();
        System.out.println(String.format("用户话费余额：赠送前=%s，赠送后=%s，赠送话费=%s。",
                oldBalance, newBalance, PRESENT_AMOUNT));
    }

}
