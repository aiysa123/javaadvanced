package com.xiaomiao.redistest;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        jedis.set("hello","world");
        System.out.println("redis�洢���ַ���Ϊ��" + jedis.get("hello"));
    }
}
