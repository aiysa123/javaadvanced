package com.xiaomiao.redistest;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        System.out.println("�����������У�" + jedis.ping());
    }
}
