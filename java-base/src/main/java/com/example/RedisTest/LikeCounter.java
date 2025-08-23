package com.example.RedisTest;

import redis.clients.jedis.Jedis;
/**
 * 一个点赞计数器，支持点赞和查询总数。
 */
public class LikeCounter {
        private Jedis jedis;
        public LikeCounter(Jedis jedis) {
            this.jedis = jedis;
        }
        // 点赞
        public long like(String id) {
            return jedis.incr("like:" + id);
        }

        // 取消点赞
        public long unlike(String id) {
            return jedis.decr("like:" + id);
        }

        // 获取点赞数
        public long getCount(String id) {
            String count = jedis.get("like:" + id);
            return count == null ? 0 : Long.parseLong(count);
        }

        public static void main(String[] args) {
                Jedis jedis = new Jedis("localhost",6379);
                LikeCounter counter = new LikeCounter(jedis);
                System.out.println("点赞数: " + counter.like("post1"));
                System.out.println("点赞数: " + counter.like("post1"));
                System.out.println("取消点赞数: " + counter.unlike("post1"));
                System.out.println("点赞数: " + counter.getCount("post1"));


        }


}