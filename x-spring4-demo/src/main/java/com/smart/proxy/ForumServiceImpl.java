package com.smart.proxy;

/**
 * 利用JDK动态代理实现AOP，移除性能监视横切代码(将它们抽取到切面中)
 */
public class ForumServiceImpl implements ForumService {

    @Override
    public void removeTopic(int topicId) {
//        PerformanceMonitor.begin(...)
        System.out.println("模拟删除Topic记录：" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
//        PerformanceMonitor.begin(...)
        System.out.println("模拟删除Forum记录：" + forumId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // PerformanceMonitor.end();
    }
}
