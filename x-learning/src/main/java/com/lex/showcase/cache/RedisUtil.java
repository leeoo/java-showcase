package com.lex.showcase.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    private static Logger log = LoggerFactory.getLogger(RedisUtil.class);

    private static final String HOST = "localhost";
    private static final int PORT = 6379;
    private static final int MAX_ACTIVE = 1000;
    private static final int MAX_IDLE = 200;
    private static final int MAX_WAIT = 100000;
    private static final int TIMEOUT = 100000;
    private static final boolean TEST_ON_BORROW = true;

    private static JedisPool pool;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);

            pool = new JedisPool(config, HOST, PORT, TIMEOUT, null);
        } catch (Exception e) {
            log.error("Exception constructing redis pool!", e);
        }
    }

    public synchronized static Jedis getJedis() {
        if (pool != null) {
            return pool.getResource();
        }
        return null;
    }

    public static void release(final Jedis jedis) {
        if (jedis != null) {
            pool.close();
        }
    }

}
