package com.lex.showcase.multiple_datasource;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.io.IOException;

/**
 * @author Lex Li
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public abstract class BaseTest {
//    static {
//        Configurator.
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        Configurator configurator = new Configurator();
//        configurator.setContext(lc);
//        lc.reset();
//        try {
//            configurator.doConfigure(new ClassPathResource("log4j2.xml").getURL());//加载logback配置文件
//        } catch (JoranException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //PropertyConfigurator.configure("/home/lhy/Workspaces/MyEclipse_data/gooddeep/src/main/java/config/log4j.properties");//加载logj配置文件
//    }

    static {
//        new ClassPathResource("log4j2.xml").getPath();
        Configurator.initialize("log4j2", "log4j2.xml");

    }
}

