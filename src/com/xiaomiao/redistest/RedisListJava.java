package com.xiaomiao.redistest;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        jedis.lpush("test-list","xiaomiao");
        jedis.lpush("test-list","rensha");
        jedis.lpush("test-list","xiaojunen");

        List<String> list = jedis.lrange("test-list", 0, 2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("�б���Ϊ��" + list.get(i));
        }
    }
}
