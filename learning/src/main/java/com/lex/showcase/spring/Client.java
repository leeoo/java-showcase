package com.lex.showcase.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lex on 2016/11/6.
 */
public class Client {
    private static Logger log = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User userBean = ctx.getBean(User.class);
        log.info(userBean);
    }
}
