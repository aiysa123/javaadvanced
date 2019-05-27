package com.xiaomiao.redistest;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.set("hello","world");
        System.out.println("redis存储的字符串为：" + jedis.get("hello"));
    }
}
