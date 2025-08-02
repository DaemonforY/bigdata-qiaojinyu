package com.example.day01.staticTest;
//static 全局变量
class MyClass {
    static int count = 0;  // 静态变量，用于记录MyClass实例的数量

    // 每次构造MyClass，都会在静态变量中累加数值
    MyClass() {
        count++;
    }

    // 静态方法，用于获取当前MyClass实例的数量
    static int getCount() {
        return count;
    }
}


public class StaticTest {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        System.out.println(MyClass.getCount()); // 输出 2
    }
}
