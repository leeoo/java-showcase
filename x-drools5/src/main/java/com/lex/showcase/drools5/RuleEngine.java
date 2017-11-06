package com.lex.showcase.drools5;

public interface RuleEngine {
    void init();

    void refresh();

    void execute(final EntityRule entityRule);
}
