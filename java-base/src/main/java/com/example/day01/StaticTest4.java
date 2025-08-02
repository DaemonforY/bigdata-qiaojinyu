package com.example.day01;

/**
 * StaticTest4 类用于演示静态变量和静态代码块的初始化过程
 */
public class StaticTest4 {
    // 定义静态变量 age 和 name，供类的所有实例共享
    static int age;
    static String name;

    // 静态代码块，用于类的初始化，只执行一次，无论创建多少个类的实例
    static {
        System.out.println("静态代码块执行");
        age = 20;
        name = "Java";
    }

    // 构造方法，每次创建类的实例时执行
    public StaticTest4() {
        System.out.println("构造方法执行");
    }


    public static void main(String[] args) {
        StaticTest4 obj1 = new StaticTest4();// 第一次触发静态代码块和构造方法
        System.out.println("==========================");
        StaticTest4 obj2 = new StaticTest4(); // 只触发构造方法
    }
}
