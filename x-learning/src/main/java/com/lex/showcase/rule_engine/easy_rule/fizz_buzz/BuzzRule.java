package com.lex.showcase.rule_engine.easy_rule.fizz_buzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * @author Lex Li
 */
@Rule
public class BuzzRule {
    @Condition
    public boolean isBuzz(@Fact("number") Integer number) {
        return number % 7 == 0;
    }

    @Action
    public void printBuzz() {
        System.out.println("buzz");
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}
