package com.lex.showcase.gof23.temp.template_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lex Li
 */
public class ParameterHandlerTest {
    private Handler handler;

    @Before
    public void setUp() {
        handler = new ParameterHandler();
    }

    @After
    public void tearDown() {
        handler = null;
    }

    @Test
    public void handle() throws Exception {
        handler.handle();
    }

}