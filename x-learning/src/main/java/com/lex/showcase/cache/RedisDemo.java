package com.lex.showcase.cache;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RedisDemo {
    private static Logger log = LoggerFactory.getLogger(RedisDemo.class);

    private Jedis jedis;

    @Before
    public void setup() {
        jedis = new Jedis("localhost", 6379);
//        jedis.auth("123456");
    }

    /**
     * 字符串存取操作
     */
    @Test
    public void testString() {
        // 添加数据
        jedis.set("name", "Ben");
        log.info(jedis.get("name"));

        // 拼接数据
        jedis.append("name", " is good man!");
        log.info(jedis.get("name"));

        // 删除数据
        jedis.del("name");
        log.info(jedis.get("name"));

        // 设置多个键值对
        jedis.mset("name", "Tom", "age", "23", "qq", "1234567890");
        // 加1操作
        jedis.incr("age");
        log.info(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }

    /**
     * Map存取操作
     */
    @Test
    public void testMap() {
        jedis.del("user"); // 先删除数据，避免对后面测试的影响

        // 添加数据
        Map<String, String> map = new HashMap<>();
        map.put("name", "Tim");
        map.put("age", "22");
        map.put("qq", "12345678");
        jedis.hmset("user", map);

        // 参数1为存入redis中map对象的key，后面跟的是放入map中的对象的key，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        log.info("rsmap: {}", rsmap);

        // 删除map中的某个键值
        jedis.hdel("user", "age");
        log.info("user.age: {}", jedis.hmget("user", "age"));
        log.info("user键对应值的字段个数: {}", jedis.hlen("user"));
        log.info("是否存在user键的记录: {}", jedis.exists("user"));
        log.info("返回user键的map对象的所有key: {}", jedis.hkeys("user"));
        log.info("返回user键的map对象的所有value: {}", jedis.hvals("user"));

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            log.info("{}:{}", key, jedis.hmget("user", key));
        }

        // 测试某个key的field是否存在
        boolean existAgeInUser = jedis.hexists("user", "age");
        log.info("existAgeInUser? {}", existAgeInUser);
        log.info("user: {}", jedis.hmget("user", "age"));
    }

    /**
     * List存取操作
     */
    @Test
    public void testList() {
        String key = "java framework";
        jedis.del(key);
        log.info("{}", jedis.lrange(key, 0, -1));

        // 从左侧放入
        jedis.lpush(key, "spring");
        jedis.lpush(key, "struts");
        jedis.lpush(key, "hibernate");
        // 参数3表示结束位置，-1表示到末尾
        log.info("{}", jedis.lrange(key, 0, -1));

        jedis.del(key);
        // 从右侧放入
        jedis.rpush(key, "spring");
        jedis.rpush(key, "struts");
        jedis.rpush(key, "hibernate");
        log.info("{}", jedis.lrange(key, 0, -1));
    }

    /**
     * Set存取操作
     */
    @Test
    public void testSet() {
        jedis.del("user"); // 先删除数据，避免对后面测试的影响

        // 添加
        String key = "user";
        jedis.sadd(key, "Ada");
        jedis.sadd(key, "Ben");
        jedis.sadd(key, "Bob");
        jedis.sadd(key, "Eva");
        jedis.sadd(key, "Yoo");
//        jedis.sadd(key, "Zoe", "Xxx");

        log.info("集合{}:{}", key, jedis.smembers(key));

        jedis.srem(key, "Yoo");
        log.info("集合{}的成员:{}", key, jedis.smembers(key));
        log.info("{}是集合的成员么？{}", "Yoo", jedis.sismember(key, "Yoo")); // 判断Yoo是否为user集合的元素
        log.info(jedis.srandmember(key));
        log.info("集合{}的所有成员:{}", key, jedis.scard(key)); // 返回集合的元素个数
    }

    @Test
    public void test() throws InterruptedException {
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");

        log.info("{}", jedis.lrange("a", 0, -1));
        log.info("{}", jedis.sort("a")); // 排序后会返回一个新的列表，而原列表保持不变
        log.info("{}", jedis.lrange("a", 0, -1));
    }
}
