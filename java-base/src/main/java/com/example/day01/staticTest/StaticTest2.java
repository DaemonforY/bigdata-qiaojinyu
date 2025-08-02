package com.example.day01.staticTest;

//static 修饰方法
class MyClass2 {
    static int count = 0;
    static void increment() {
        count++;
    }
}
public class StaticTest2 {
    public static void main(String[] args) {
        // 直接使用类名调用方法，而不需要创建类实例
        MyClass2.increment();
        System.out.println(MyClass2.count);  // 输出 1
    }
}
