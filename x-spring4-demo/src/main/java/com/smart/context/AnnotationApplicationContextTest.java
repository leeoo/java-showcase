package com.smart.context;

import com.smart.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @author Lex Li
 */
public class AnnotationApplicationContextTest {

    @Test
    public void getBean() {
        // 通过一个带@Configuration的POJO装载Bean配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = (Car) ctx.getBean("car");
        assertNotNull(car);
    }
}
