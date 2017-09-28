package com.lex.showcase.cache;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class RedisUtilTest {

    @Test
    public void test() {
        Jedis jedis = RedisUtil.getJedis();
        assertNotNull(jedis);

        RedisUtil.release(jedis);
    }

}