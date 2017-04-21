package com.lex.showcase.gof23.creational.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 */
public class Client {
    private static Logger log = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        // 范型工厂，传入什么类型就返回什么类型，不用手动强制类型转换。Spring的 BeanFactory 接口就是这样实现的。
        AssetFactory factory = new AssetFactoryImpl();
        try {
            Loan loan = factory.getBean(Loan.class);
            loan.setName("IBM 3 Year's Term Loan");
            loan.setCusip("ABCDE123");
            loan.setPrice(90.5);

            Bond bond = factory.getBean(Bond.class);
            bond.setName("Google 5 Year's Bond");
            bond.setIsin("ABCDEF001");
            bond.setPrice(96.75);

            log.info(loan.getClass());
            log.info(bond.getClass());
        } catch (Exception e) {
            log.error("Exception getting bean!", e);
        }
    }
}
