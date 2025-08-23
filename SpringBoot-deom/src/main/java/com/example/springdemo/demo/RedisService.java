package com.example.springdemo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    public void demo() {
        // String
        redisTemplate.opsForValue().set("hello", "world");
        String v = redisTemplate.opsForValue().get("hello");
        System.out.println("hello: " + v);

        // List
        redisTemplate.opsForList().leftPush("queue", "task1");
        redisTemplate.opsForList().leftPush("queue", "task2");
        String task = redisTemplate.opsForList().rightPop("queue");
        System.out.println("task: " + task);

        // Hash
        redisTemplate.opsForHash().put("user:1", "name", "Bob");
        Object name = redisTemplate.opsForHash().get("user:1", "name");
        System.out.println("user:1 name: " + name);
    }

    public String login(String username) {
        String key = username;
        Long count = redisTemplate.opsForValue().increment(key);
        System.out.println(" 登录次数：" + count);
        return username + " 登录次数：" + count;
    }

    /**
     * 用户登录后将 session 缓存到 Redis 中
     *
     */
    public String loginWithSession() {
        redisTemplate.opsForValue().set("session:bob", "id");
        Object name = redisTemplate.expire("session:bob", Duration.ofMinutes(10));
        System.out.println("session:bob: " + name);
        System.out.println("剩余时间："+redisTemplate.getExpire("session:bob"));
        return "session:bob: " + name +"剩余时间："+redisTemplate.getExpire("session:bob");
    }

}