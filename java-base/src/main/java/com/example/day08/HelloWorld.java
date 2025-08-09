package com.example.day08;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("Hello World  - my thread");
            }
        };
        thread.start();
        Thread.yield();  //  释放当前线程的执行权，让其他线程有机会执行。
        // 如果不调用Thread.yield()，由于创建新线程要花一些时间，那么main线程几乎肯定会先执行print
        // 当然也不一定，并发编程有一个规律：如果某件事可能会发生，那么不论多么艰难，肯定会发生，而且可能发生在最不利的时刻
        System.out.println("Hello World  - main thread");
        thread.join();

        //试着将Thread.yield()注释掉，看看会发生什么。如果换成Thread.sleep(1)呢
    }
}
