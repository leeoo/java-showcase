package com.lex.showcase.rule_engine.easy_rule.fizz_buzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * @author Lex Li
 */
@Rule//(name = "fizzRule", description = "Fizz rule")
public class FizzRule {
    @Condition
    public boolean isFizz(@Fact("number") Integer number) {
        return number % 5 == 0;
    }

    @Action
    public void printFizz() {
        System.out.println("fizz");
    }

    @Priority
    public int getPriority() {
        return 1;
    }
}
