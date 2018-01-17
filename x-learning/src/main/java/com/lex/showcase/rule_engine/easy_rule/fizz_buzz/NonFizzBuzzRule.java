package com.lex.showcase.rule_engine.easy_rule.fizz_buzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;

/**
 * @author Lex Li
 */
public class NonFizzBuzzRule {
    @Condition
    public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
        return number % 5 != 0 && number % 7 != 0;
    }

    @Action
    public void printInput(@Fact("number") Integer number) {
        System.out.println(number);
    }

    @Priority
    public int getPriority() {
        return 3;
    }
}
