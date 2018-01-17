package com.lex.showcase.rule_engine.easy_rule.points;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import java.math.BigDecimal;

/**
 * @author Lex Li
 */
public class PointsRuleTest {

    public static void main(String[] args) {
        // define fact
        Facts facts = new Facts();
        facts.put("pointsAccount", new PointsAccount("00000001", "000000001",
                "BANK_CARD_00001", BigDecimal.ZERO));
        // define rule
        Rules rules = new Rules(new PointsRule());
//        rules.register(new PointsRule());

        // fire
        RulesEngine ruleEngine = new DefaultRulesEngine();
        ruleEngine.fire(rules, facts);
    }
}
