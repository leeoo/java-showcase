package com.lex.showcase.multiple_datasource.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 获取动态数据源类别的切面类，存储在@see DataSourceHolder
 */
public class DataSourceAspect {

    private static Logger log = LoggerFactory.getLogger(DataSourceAspect.class);

    public void getRoutingKey(JoinPoint jp) {
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

    public void restoreDataSource(JoinPoint joinPoint) {
        Method m = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (m != null && m.isAnnotationPresent(DataSource.class)) {
            DataSourceHolder.remove();
        }
    }
}
