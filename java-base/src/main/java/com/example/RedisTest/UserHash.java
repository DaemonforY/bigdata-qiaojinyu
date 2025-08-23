package com.example.RedisTest;

import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;

/**
 *  Hash 存储用户信息，实现增查改。
 * **/
public class UserHash {
    private Jedis jedis;

    public UserHash(Jedis jedis) {
        this.jedis = jedis;
    }

    // 添加用户
    public void addUser(String userId, String name, int age, String email) {
        Map<String, String> user = new HashMap<>();
        user.put("name", name);
        user.put("age", String.valueOf(age));
        user.put("email", email);
        jedis.hset("user:" + userId, user);
    }

    // 获取用户信息
    public Map<String, String> getUser(String userId) {
        return jedis.hgetAll("user:" + userId);
    }

    // 更新用户字段
    public void updateUser(String userId, String field, String value) {
        jedis.hset("user:" + userId, field, value);
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        UserHash userHash = new UserHash(jedis);
        userHash.addUser("1", "张三", 18, "zhangsan@example.com");
        System.out.println(userHash.getUser("1"));
        userHash.updateUser("1", "age", "19");
    }
}