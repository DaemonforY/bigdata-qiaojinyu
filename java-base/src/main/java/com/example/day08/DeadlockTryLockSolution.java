package com.example.day08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 tryLock 解决死锁问题的示例类
 * 通过非阻塞方式尝试获取锁，避免了传统顺序锁获取可能导致的死锁情况
 */
public class DeadlockTryLockSolution {
    // 定义两个锁，用于演示死锁的避免
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    /**
     * 线程A类，尝试按照lock1 -> lock2的顺序获取锁
     * 通过tryLock方式获取锁，避免死锁
     */
    private static class TryLockThreadA extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    // 尝试获取lock1
                    if (lock1.tryLock()) {
                        System.out.println("Thread A: Holding lock 1...");
                        Thread.sleep(50);
                        // 在持有lock1的情况下尝试获取lock2
                        if (lock2.tryLock()) {
                            try {
                                System.out.println("Thread A: Holding lock 1 & 2...");
                                break; // 成功获得锁，完成工作
                            } finally {
                                lock2.unlock();
                            }
                        }
                        lock1.unlock();  // 释放 lock1，尝试重新获取
                    }
                    Thread.sleep(50);  // 等待一段时间后重试
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 线程B类，尝试按照lock1 -> lock2的顺序获取锁
     * 通过tryLock方式获取锁，避免死锁
     */
    private static class TryLockThreadB extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    // 尝试获取lock1
                    if (lock1.tryLock()) {
                        System.out.println("Thread B: Holding lock 1...");
                        Thread.sleep(50);
                        // 在持有lock1的情况下尝试获取lock2
                        if (lock2.tryLock()) {
                            try {
                                System.out.println("Thread B: Holding lock 1 & 2...");
                                break; // 成功获得锁，完成工作
                            } finally {
                                lock2.unlock();
                            }
                        }
                        lock1.unlock();  // 释放 lock1，尝试重新获取
                    }
                    Thread.sleep(50);  // 等待一段时间后重试
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 主函数，创建并启动线程A和线程B
     * 演示如何通过tryLock方式避免死锁
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Thread threadA = new TryLockThreadA();
        Thread threadB = new TryLockThreadB();

        threadA.start();
        threadB.start();
    }
}
