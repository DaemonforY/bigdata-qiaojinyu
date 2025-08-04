package com.example.day03;

// 引入 ArrayList 和 Iterator 类
import java.util.ArrayList;
import java.util.Iterator;
/*ava迭代器（Iterator）是 Java 集合框架中的一种机制，
是一种用于遍历集合（如列表、集合和映射等）的接口。*/
public class IteratorTest {
    public static void main(String[] args) {

        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        // 获取迭代器
        Iterator<String> it = sites.iterator();
        // 输出集合中的第一个元素
        System.out.println(it.next());
        System.out.println("输出集合中的所有元素");
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it1 = numbers.iterator();
        while(it1.hasNext()) {
            Integer i = it1.next();
            if(i < 10) {
                it1.remove();  // 删除小于 10 的元素
            }
        }
        System.out.println(numbers);

    }
}