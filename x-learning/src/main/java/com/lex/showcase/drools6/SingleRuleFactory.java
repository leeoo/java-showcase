package com.lex.showcase.drools6;

import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;


/**
 * To create a singleton factory.
 */
public class SingleRuleFactory {
    private static RuleBase ruleBase;

    public static RuleBase getRuleBase() {
        return ruleBase != null ? ruleBase : RuleBaseFactory.newRuleBase();
    }
}
