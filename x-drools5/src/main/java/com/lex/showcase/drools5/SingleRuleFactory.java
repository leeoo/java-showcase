package com.lex.showcase.drools5;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;


/**
 * To create a singleton factory.
 */
public class SingleRuleFactory {
    private static RuleBase ruleBase;

    public static RuleBase getRuleBase() {
        return ruleBase != null ? ruleBase : RuleBaseFactory.newRuleBase();
    }
}
