package com.example.day07;

public class Q5_AlternatePrinting {
    public static void main(String[] args) {
        System.out.println("=== 题目5：多线程交替打印（演示前10个数字） ===\n");
        System.out.println("题目5：多线程交替打印（演示前10个数字）");
        AlternatingPrinter printer = new AlternatingPrinter();
        Thread thread1 = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "偶数线程");
        Thread thread2 = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "奇数线程");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n多线程打印完成！");
    }

    static class AlternatingPrinter {
        private int count = 1;
        private final Object lock = new Object();
        private boolean isOdd = true;
        public void printOdd() throws InterruptedException {
            while (count <= 10) {
                synchronized (lock) {
                    while (!isOdd) {
                        lock.wait();
                    }
                    if (count <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        isOdd = false;
                        lock.notify();
                    }
                }
            }
        }
        public void printEven() throws InterruptedException {
            while (count <= 10) {
                synchronized (lock) {
                    while (isOdd) {
                        lock.wait();
                    }
                    if (count <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        isOdd = true;
                        lock.notify();
                    }
                }
            }
        }
    }
}
