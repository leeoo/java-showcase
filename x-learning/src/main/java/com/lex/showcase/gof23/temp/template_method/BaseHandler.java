package com.lex.showcase.gof23.temp.template_method;

/**
 * @author Lex Li
 */
public abstract class BaseHandler implements Handler {
    /**
     * Initialize the necessary resources.
     */
    protected abstract void init();

    /**
     * Process the main logic.
     */
    protected abstract void process();

    /**
     * Post resources.
     */
    protected abstract void post();

    @Override
    public void handle() {
        init();
        process();
        post();
    }
}
