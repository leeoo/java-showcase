package com.lex.showcase.concurrency.grabbing_red_packet;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * 模拟大量并发用户请求抢少量红包的场景
 *
 */
public class Demo2 {

    private static Logger log = LoggerFactory.getLogger(Demo.class);
    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int RED_PACKETS_COUNT = 1_0000;
    private static final int USERS_COUNT = 10_0000;

    // redPacketList
    private static ConcurrentLinkedDeque<Map<String, Object>> hongBaoList = new ConcurrentLinkedDeque<>();
//    private static ConcurrentLinkedDeque<Map<String, Object>> userList = new ConcurrentLinkedDeque<>();
    private static ConcurrentLinkedDeque<Map<String, Object>> hongBaoConsumedList = new ConcurrentLinkedDeque<>();
    private static ConcurrentHashMap hongBaoConsumedMap = new ConcurrentHashMap();

    static StopWatch watch = new StopWatch();
    static String host = "localhost";

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayBlockingQueue<Map<String, Object>> maps = generateRedPackets();
        hongBaoList.addAll(maps);
        log.info("{}个线程生成了{}个红包，耗时：{}ms", THREAD_COUNT, maps.size(), System.currentTimeMillis()- start);

        log.info("用户抢红包...");
        rushToGetRedPackets();
        log.info("红包被抢光.");
    }

    public static ArrayBlockingQueue<Map<String, Object>> generateRedPackets() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        // 用map表示红包，包含id、amount等key，简单使用循环的序号来保证id唯一
        ArrayBlockingQueue<Map<String, Object>> redPackets = new ArrayBlockingQueue<>(RED_PACKETS_COUNT);
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

    private static void rushToGetRedPackets() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        System.out.println("start:" + System.currentTimeMillis() / 1000);
        watch.start();
        for (int i = 0; i < THREAD_COUNT; ++i) {
            final int temp = i;
            Thread thread = new Thread() {
                public void run() {
//                    Jedis jedis = new Jedis(host);
//                    String sha = jedis.scriptLoad(tryGetHongBaoScript); // TODO
                    int j = RED_PACKETS_COUNT / THREAD_COUNT * temp;
                    while (true) {
//                        Object object = jedis.eval(tryGetHongBaoScript, 4,
//                                hongBaoList, hongBaoConsumedList, hongBaoConsumedMap, "" + j);
                                // TODO
                        Object obj = null;
                        String userId = "" + j;
//                        synchronized (Demo2.class) {
                            if (hongBaoConsumedMap.containsKey(userId)) {
                                log.info("当前用户{}已抢到了红包!", userId);
                                obj = null;
                            } else {
                                // 取出Queue最末尾的红包
                                Map hongbao = hongBaoList.pollLast();
                                log.info("hongBao: {}", hongbao);
                                if (hongbao != null) { // TODO
                                    hongbao.put("userId", userId);

                                    obj = hongbao; // TODO

                                    hongBaoConsumedMap.put(userId, userId);
                                    hongBaoConsumedList.offerFirst((Map)obj);
                                }
                            }

//                        }
                            j++;
                            if (obj != null) {
                              log.info("get hongBao:{}", obj);
                            } else {
    //                            if (jedis.llen(hongBaoList) == 0)
                                if (hongBaoList.isEmpty()) {
                                    log.info("已经取完了!");
                                    break;
                                }
                            }

                    }
                    latch.countDown();
                }
            };
            thread.start();
        }

        latch.await();
        watch.stop();

        System.out.println("time:" + watch.getTotalTimeSeconds());
        System.out.println("speed:" + RED_PACKETS_COUNT / watch.getTotalTimeSeconds());
        System.out.println("end:" + System.currentTimeMillis() / 1000);
    }
}
