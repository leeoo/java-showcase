package com.lex.showcase.rule_engine.easy_rule.fizz_buzz;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;

/**
 * @author Lex Li
 */
public class FizzBuzzWithEasyRules {

    public static void main(String[] args) {
        // crete rules engine
        RulesEngine fizzBuzzEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build();

        // create rules
        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new FizzBuzzRule());
        rules.register(new NonFizzBuzzRule());
    }
}
