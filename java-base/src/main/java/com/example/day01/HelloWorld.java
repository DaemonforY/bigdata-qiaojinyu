package com.example.day01;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld);

        System.out.println(HelloWorld.a);

        char ch = 'a';
        Character c = 'a';
        String s = "ab";
        char c1 = s.charAt(0);
        System.out.println(s.charAt(0));

        //        new Integer()
    }

    public static String a = "a";
    String b = "b";
}
