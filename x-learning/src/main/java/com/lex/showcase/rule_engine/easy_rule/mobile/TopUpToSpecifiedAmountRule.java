package com.lex.showcase.rule_engine.easy_rule.mobile;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.math.BigDecimal;

/**
 * 手机话费充值达到特定金额规则 - 当月充值金额达到100以上，每达到一次赠送话费10元。
 * TODO 可变量：当月（可以是其他的如当天、当季、半年里、当年、最近半年里、指定的时间段等），充值金额。
 * TODO 可变量要么通过参数传入、要么使用模板配置、要么从DB里加载。
 * TODO 通过DB或者模板配置文件来配置的话，必须要有刷新机制！而且DB来配置的话要有历史变更流水表。
 * @author Lex Li
 */
@Rule(name = "TopUpToSpecifiedAmountRule", description = "Top up to specified amount rule")
public class TopUpToSpecifiedAmountRule {

    // TODO Loading/Injecting from Configuration Template? (See RuleParameter.properties )
    private static final BigDecimal SPECIFIED_AMOUNT = new BigDecimal(100);
    private static final BigDecimal PRESENT_AMOUNT = new BigDecimal(10);


    @Condition
    public boolean when(@Fact("topUpToSpecifiedAmountFact") MobileAccount account) {
        return account != null && account.getTopUpAmountCurrentMonth().doubleValue() >= SPECIFIED_AMOUNT.doubleValue();
    }

    /**
     * 操作：送话费
     * @param account
     */
    @Action
    public void then(@Fact("topUpToSpecifiedAmountFact") MobileAccount account) {
//        System.out.println("新开户用户，送20元话费。");

        BigDecimal oldBalance = account.getBalance();
        BigDecimal topUpAmountCurrentMonth = account.getTopUpAmountCurrentMonth();
        final BigDecimal presentAmount = account.getTopUpAmountCurrentMonth().divide(SPECIFIED_AMOUNT).multiply(PRESENT_AMOUNT);
        account.setBalance(oldBalance.add(presentAmount));
        BigDecimal newBalance = account.getBalance();

        System.out.println(String.format("用户话费余额：赠送前=%s，赠送后=%s；当月充值金额=%s，赠送话费=%s。",
                oldBalance, newBalance, topUpAmountCurrentMonth, presentAmount));
    }

}
