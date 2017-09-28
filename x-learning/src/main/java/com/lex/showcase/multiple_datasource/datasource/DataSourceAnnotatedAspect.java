package com.lex.showcase.multiple_datasource.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 获取动态数据源类别的切面类，存储在@see DataSourceHolder
 */
@Aspect
@Component
public class DataSourceAnnotatedAspect {

    private static Logger log = LoggerFactory.getLogger(DataSourceAnnotatedAspect.class);

    @Pointcut("@annotation(com.lex.showcase.multiple_datasource.datasource.DataSource)")
    public void process() {
        log.info("Inside Process ...");
    }

    /*
     * 另一种写法是把process()方法去掉，本方法上的注解改成：
     * @Before("@annotation(com.lex.showcase.multiple_datasource.datasource.DataSource)")
     */
    @Before("process()")
    public void getRoutingKey(JoinPoint jp) {
        log.info("Inside Actual Aspect ..");
        Method m = ((MethodSignature) jp.getSignature()).getMethod();

        try {
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource dataSource = m.getAnnotation(DataSource.class);
                DataSourceHolder.put(dataSource.value());
            } else {
                DataSourceHolder.put(DataSourcePolicy.MASTER);
            }
        } catch (SecurityException e) {
            log.error("get datasource routing Key error", e);
            DataSourceHolder.put(DataSourcePolicy.MASTER);
        } catch (Exception e) {
            log.error("get datasource routing Key error", e);
            DataSourceHolder.put(DataSourcePolicy.MASTER);
        }
    }

    @After("@annotation(com.lex.showcase.multiple_datasource.datasource.DataSource)")
    public void restoreDataSource(JoinPoint joinPoint) {
        Method m = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (m != null && m.isAnnotationPresent(DataSource.class)) {
            DataSourceHolder.remove();
        }
    }
}
