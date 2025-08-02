package com.example.day01;

public class Two {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");

        System.out.println(s1.equals(s2)); // true（内容相同）

// 自定义类
        class Person {
            String name;
            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Person) {
                    return this.name.equals(((Person) obj).name);
                }
                return false;
            }
        }
    }
}
