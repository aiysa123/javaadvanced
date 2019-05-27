package com.xiaomiao.redistest;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class RedisKeyJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();

        while (it.hasNext()){
            String key = it.next();
            System.out.println("key:" + key);
        }

    }
}
