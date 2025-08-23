package com.example.RedisTest;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

/**
 *  ZSet 实现一个积分排行榜，并查询Top3。
 * **/
public class Ranking {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.zadd("rank", 100, "Tom");
        jedis.zadd("rank", 80, "Alice");
        jedis.zadd("rank", 90, "Bob");
        // 查询前三名
        Set<String> top3 = new HashSet<>(jedis.zrevrange("rank", 0, 2));
        System.out.println("排行榜前3名："+ top3 );
        jedis.close();

    }
}
