package com.example.day08;

import java.util.LinkedList;

/**
 * PC类实现了生产者-消费者问题中的生产者和消费者逻辑
 * 它使用一个LinkedList作为共享资源，用于存储生产者生产和消费者消费的元素
 */
class PC {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    /**
     * 生产者方法，负责生成元素并添加到共享资源中
     * 当共享资源已满时，生产者会等待直到消费者消费掉部分元素
     * @throws InterruptedException 当线程被中断时抛出此异常
     */
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == capacity)
                    wait();

                System.out.println("Producer produced-" + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    /**
     * 消费者方法，负责从共享资源中取出并消费元素
     * 当共享资源为空时，消费者会等待直到生产者生产出新的元素
     * @throws InterruptedException 当线程被中断时抛出此异常
     */
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0)
                    wait();

                int val = list.removeFirst();
                System.out.println("Consumer consumed-" + val);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}

/**
 * ProducerConsumerExample类包含了主程序入口，用于启动生产者线程和消费者线程
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
