package com.lex.showcase.rule_engine.easy_rule.mobile;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import java.math.BigDecimal;

/**
 * @author Lex Li
 */
public class TopUpRuleTest {
    /*
举一个手机话费的例子。

一、定义规则：

首先要分析自己的业务逻辑，根据业务而制定出不同的规则，这里我们假设有3个规则。

1、对于新开户的手机用户送20元话费。

2、在2014年10月到12期间充值的用户，不论金额多少充值满3次就赠送5元话费。

3、当月充值金额达到100以上，每达到一次赠送话费10元。
*/
    public static void main(String[] args) {
        // define facts
        Facts facts = new Facts();
        facts.put("topUpFact",
                new MobileAccount("15812345678", "张三", BigDecimal.ZERO, true));


        // define rules
        Rules rules = new Rules(new TopUpTimesInSpecifiedDurationRule());

        // fire
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}
