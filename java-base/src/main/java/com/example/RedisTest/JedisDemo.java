package com.example.RedisTest;

import redis.clients.jedis.Jedis;

public class JedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        // String
        jedis.set("name", "Alice");
        String value = jedis.get("name");
        System.out.println("name: " + value);

        // List
        jedis.lpush("queue", "task1");
        jedis.lpush("queue", "task2");
        String task = jedis.rpop("queue");
        System.out.println("task: " + task);

        // Hash
        jedis.hset("user:1", "name", "Bob");
        jedis.hset("user:1", "age", "22");
        System.out.println("user:1 name: " + jedis.hget("user:1", "name"));
        System.out.println("user:1 info: " + jedis.hgetAll("user:1"));

        jedis.close();
    }
}