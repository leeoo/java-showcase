package com.lex.showcase.rule_engine.easy_rule.fizz_buzz;

import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.core.CompositeRule;

/**
 * @author Lex Li
 */
@Rule
public class FizzBuzzRule extends CompositeRule {

    public FizzBuzzRule(Object... rules) {
        for (Object rule : rules) {
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
