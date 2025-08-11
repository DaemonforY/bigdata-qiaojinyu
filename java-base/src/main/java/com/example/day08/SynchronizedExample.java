package com.example.day08;
/**
 * BankAccount 类表示一个银行账户，包含一个同步的取款方法以确保线程安全
 */
class BankAccount {
    /**
     * 账户余额，初始为100
     */
    private int balance = 100;

    /**
     * 同步方法，处理取款逻辑
     *
     * @param amount 要取款的金额
     * @param name   执行取款操作的线程名称
     *
     */
    public synchronized void withdraw(int amount, String name) {
        if (balance >= amount) {
            System.out.println(name + " is going to withdraw");
            balance -= amount;
            System.out.println(name + " completed the withdrawal, remaining balance: " + balance);
        } else {
            System.out.println(name + " cannot withdraw due to insufficient balance, remaining balance: " + balance);
        }
    }
}

/**
 * SynchronizedExample 类用于演示同步方法在多线程环境下的使用
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        // 创建一个银行账户实例
        final BankAccount account = new BankAccount();
        // 定义一个Runnable任务，用于执行取款操作
        Runnable task = () -> account.withdraw(60, Thread.currentThread().getName());

        // 创建两个线程，每个线程都执行相同的取款任务
        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        // 启动线程
        t1.start();
        t2.start();
    }
}
