package com.lex.showcase.concurrency.grabbing_red_packet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * See http://blog.csdn.net/hengyunabc/article/details/19433779/
 */
public class Demo {
    private static Logger log = LoggerFactory.getLogger(Demo.class);
    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int RED_PACKETS_COUNT = 10_0000;

    private static List<Map<String, Object>> redPacketList = new ArrayList<>();
    private static List<Map<String, Object>> userList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        log.info("{}个线程生成{}个红包供用户抢", THREAD_COUNT, RED_PACKETS_COUNT);
        long start = System.currentTimeMillis();
        redPacketList.addAll(generateData());
        log.info("红包生成完毕，耗时：{}ms", System.currentTimeMillis()- start);

//        log.info("用户抢{}个红包", THREAD_COUNT);

    }

    public static List<Map<String, Object>> generateData() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        // 用map表示红包，包含id、amount等key，简单使用循环的序号来保证id唯一
        List<Map<String, Object>> redPackets = new ArrayList<>();
        // 所有线程均分红包总量
        int per = RED_PACKETS_COUNT / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int temp = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = temp * per; j < (temp + 1) * per; j++) {
                        Map<String, Object> redPacket = new HashMap<>();
                        redPacket.put("id", j);
                        redPacket.put("amount", 10.0);
                        redPackets.add(redPacket);
                        log.info("生成红包{}", redPacket);
                    }
                    latch.countDown();
                }
            });
            thread.start();
        }
        latch.await();
        return redPackets;
    }

    public static void simulateGrabbingRedPacket() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        int userCount = RED_PACKETS_COUNT * 10; // 用户量为红包量的10倍
        List<Map<String, Object>> users = new ArrayList<>(userCount);
        int per = userCount / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int temp = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = temp * per; j < (temp + 1) * per; j++) {
                        // TODO
                    }
                    latch.countDown();
                }
            });
            thread.start();
        }
        latch.await();
    }
}
