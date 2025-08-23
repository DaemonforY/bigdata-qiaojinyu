package com.example.RedisTest;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost",6379);
        //1.用 String 实现一个访问计数器，每访问一次就自增
        long count = jedis.incr("visit:counter");
        System.out.println("当前访问次数：" + count);
        System.out.println("=================================");
        //2.用 List 实现一个简单消息队列，生产者 lpush，消费者 rpop
        // 生产者
        jedis.lpush("queue:message", "消息21");
        jedis.lpush("queue:message", "消息12");
        // 消费者
        String msg = jedis.rpop("queue:message");
        System.out.println("消费消息：" + msg);
        System.out.println("================================");
        //3. 用 Set 实现抽奖池，去重添加参与者，随机抽取一名
        jedis.sadd("set:lottery", "Alice", "Bob", "Charlie");
        String winner = jedis.srandmember("set:lottery");
        System.out.println("中奖者：" + winner);
        System.out.println("================================");
        //4. 用 Hash 存储和查询用户 profile 信息
        jedis.hset("user:1001", "name", "Alice");
        jedis.hset("user:1001", "age", "20");
        String name = jedis.hget("user:1001", "name");
        Map<String, String> profile = jedis.hgetAll("user:1001");
        System.out.println("姓名：" + name);
        System.out.println("完整信息：" + profile);
        System.out.println("=================================");
        //5.用 ZSet 实现积分排行榜，支持加分和查询前3名
        jedis.zadd("rank", 100, "Tom");
        jedis.zadd("rank", 80, "Alice");
        jedis.zadd("rank", 90, "Bob");
        // Alice加10分
        jedis.zincrby("rank", 10, "Alice");
        // 查询前三名
        Set<String> top3 = new HashSet<>(jedis.zrevrange("rank", 0, 2));
        System.out.println("排行榜前3名："+ top3 );
        jedis.close();


    }
}