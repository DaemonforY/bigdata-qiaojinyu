package com.example.RedisTest;

import redis.clients.jedis.Jedis;
/**
 *  Lua 脚本实现原子性扣减库存。
 * **/
public class Stock {
    // Lua脚本：原子扣减库存
    private static final String STOCK_LUA =
            "if redis.call('get', KEYS[1]) >= ARGV[1] then " +
                    "   return redis.call('decrby', KEYS[1], ARGV[1]) " +
                    "else " +
                    "   return -1 " +
                    "end";

    private Jedis jedis;

    public Stock(Jedis jedis) {
        this.jedis = jedis;
    }

    // 初始化库存
    public void initStock(String productId, int num) {
        jedis.set("stock:" + productId, String.valueOf(num));
    }

    // 扣减库存
    public long deduct(String productId, int num) {
        return (Long) jedis.eval(STOCK_LUA, 1,
                "stock:" + productId, String.valueOf(num));
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        Stock stock = new Stock(jedis);

        String productId = "1001";
        int initStockNum = 100;
        stock.initStock(productId, initStockNum); // 初始化库存为 100

        int deductNum = 10;
        long remainingStock = stock.deduct(productId, deductNum); // 扣减库存 10

        if (remainingStock >= 0) {
            System.out.println("成功扣减库存，剩余库存：" + remainingStock);
        } else {
            System.out.println("库存不足，无法扣减");
        }

        jedis.close(); // 关闭 Redis 连接
    }
}