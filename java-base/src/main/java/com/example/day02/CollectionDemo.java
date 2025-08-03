package com.example.day02;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        // Collection示例
        Collection<String> collection = new ArrayList<>();
        collection.add("Element 1");
        collection.add("Element 2");
        System.out.println("Collection: " + collection);

        // List示例
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 1"); // List允许重复元素
        System.out.println("List: " + list);

        // Set示例
        Set<String> set = new HashSet<>();
        set.add("Unique 1");
        set.add("Unique 2");
        set.add("Unique 1"); // Set会自动去掉重复元素
        System.out.println("Set: " + set);

        // Map示例
        Map<String, Integer> map = new HashMap<>();
        map.put("Key1", 100);
        map.put("Key2", 200);
        map.put("Key1", 300); // Map会覆盖重复的键
        System.out.println("Map: " + map);

        // 遍历集合
        System.out.println("\n遍历 Collection:");
        for (String item : collection) {
            System.out.println(item);
        }

        System.out.println("\n遍历 List:");
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("\n遍历 Set:");
        for (String item : set) {
            System.out.println(item);
        }

        System.out.println("\n遍历 Map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

    }
}
