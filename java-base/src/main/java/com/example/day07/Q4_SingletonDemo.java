package com.example.day07;

public class Q4_SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== 题目4：单例模式实现 ===\n");
        System.out.println("题目4：单例模式实现");
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("单例对象是否相同: " + (singleton1 == singleton2));
        System.out.println("单例对象hashCode: " + singleton1.hashCode() + " vs " + singleton2.hashCode());
        System.out.println();
    }

    static class Singleton {
        private static volatile Singleton instance;
        private Singleton() { }
        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
