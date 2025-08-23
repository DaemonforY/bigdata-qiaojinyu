package com.example.RedisTest;

import redis.clients.jedis.Jedis;

public class RedisJava1 {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost",6379);
        //设置一个 key 10 秒后自动删除，并用 `TTL` 验证它的剩余时间和到期后自动消失。
        jedis.set("temp", "will expire");
        jedis.expire("temp", 10);
        //jedis.setex("temp",10,"will expire");
        System.out.println("TTL: " + jedis.ttl("temp"));
        jedis.close();
    }

}
