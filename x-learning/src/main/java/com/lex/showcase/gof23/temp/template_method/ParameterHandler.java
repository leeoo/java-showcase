package com.lex.showcase.gof23.temp.template_method;

/**
 * @author Lex Li
 */
public class ParameterHandler extends BaseHandler {

    @Override
    protected void init() {
        System.out.println("Initialize the necessary resources.");
    }

    @Override
    protected void process() {
        System.out.println("Process the main logic.");
    }

    @Override
    protected void post() {
        System.out.println("Post resources.");
    }
}
