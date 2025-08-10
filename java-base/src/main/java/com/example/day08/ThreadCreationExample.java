package com.example.day08;
//创建并启动线程
// 实现 Runnable 接口
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread using Runnable is running");
    }
}

// 继承 Thread 类
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread using Thread is running");
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new MyThread();

        thread1.start();
        thread2.start();
    }
}