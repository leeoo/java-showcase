package com.lex.showcase.drools6;

/**
 * @author Lex Li
 */
public interface RuleEngine {
    void init();

    void refresh();

    void execute(final EntityRule entityRule);
}
