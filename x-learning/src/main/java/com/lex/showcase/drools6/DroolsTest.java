package com.lex.showcase.drools6;

public class DroolsTest {
    public static void main(String[] args) {
        RuleEngine engineImpl = new RuleEngineImpl();
        engineImpl.init();
        final EntityRule entityRule = new EntityRule();
        entityRule.setCurrentmoney(350d);
        entityRule.setUsername("Candy");
        entityRule.setAccount(true);
        entityRule.setTotaladdmoney(350d);
        entityRule.setAddtime(7);
        engineImpl.execute(entityRule);
    }
}
