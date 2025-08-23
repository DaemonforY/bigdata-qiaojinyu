package com.example.RedisTest;
import redis.clients.jedis.Jedis;


/**
 * 实现接口防刷（限流），每个IP每分钟至多访问10次。
 * **/
public class RateLimit {
    private Jedis jedis;
    private int maxRequests; // 最大请求数
    private int period; // 时间窗口(秒)

    public RateLimit(Jedis jedis, int maxRequests, int period) {
        this.jedis = jedis;
        this.maxRequests = maxRequests;
        this.period = period;
    }

    // 检查是否允许请求
    public boolean allowRequest(String ip) {
        String key = "limit:" + ip;
        Long count = jedis.incr(key);

        // 第一次设置过期时间
        if (count == 1) {
            jedis.expire(key, period);
        }

        return count <= maxRequests;
    }
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        RateLimit rateLimit = new RateLimit(jedis, 2, 60);
        System.out.println(rateLimit.allowRequest("192.168.1.1"));

    }
}