package com.example.RedisTest;

import redis.clients.jedis.Jedis;

//用 key 记录用户/接口的访问次数，每次访问自增，首次访问设置60秒过期，超过5次则拒绝。
public class JedisCounterDemo {

    /**
     * 检查用户访问是否超过限制
     * @param userId 用户ID
     * @return 是否允许访问
     */
    public static boolean checkAccess(String userId) {
        // 使用try-with-resources自动关闭Jedis连接
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            // 构建用户访问计数的key
            String key = "req:user:" + userId;

            // 自增计数（原子操作）
            long count = jedis.incr(key);

            // 首次访问时设置过期时间（60秒）
            if (count == 1) {
                jedis.expire(key, 60);
            }
            // 检查是否超过访问限制
            return count <= 5;
        } catch (Exception e) {
            // 处理Redis连接或操作异常
            System.err.println("Redis操作异常: " + e.getMessage());
            // 异常情况下默认允许访问（或根据业务需求调整）
            return true;
        }
    }

    public static void main(String[] args) {
        // 测试用户ID
        String testUserId = "user123";

        // 模拟7次访问
        for (int i = 1; i <= 7; i++) {
            boolean allowed = checkAccess(testUserId);
            System.out.println("第" + i + "次访问: " + (allowed ? "允许访问" : "访问过于频繁！"));

            // 每次访问间隔1秒，方便观察效果
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
