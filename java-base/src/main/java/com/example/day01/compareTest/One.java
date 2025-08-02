package com.example.day01.compareTest;

public class One {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println(a == b); // true（值相等）

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2); // true（字符串常量池，同一对象）
        System.out.println(s1 == s3); // false（不同对象，地址不同）



    }
}
