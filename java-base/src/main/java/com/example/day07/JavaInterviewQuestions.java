package com.example.day07;

import java.util.*;


public class JavaInterviewQuestions {
    
    public static void main(String[] args) {
        System.out.println("=== Java面试题解答 ===\n");
        
        // 题目1：字符串反转
        question1();
        
        // 题目2：查找数组中的重复元素
        question2();
        
        // 题目3：判断字符串是否为回文
        question3();
        
        // 题目4：实现单例模式
        question4();
        
        // 题目5：多线程交替打印
        question5();
    }
    
    /**
     * 题目1：字符串反转
     * 要求：不使用StringBuilder/StringBuffer，实现字符串反转
     */
    public static void question1() {
        System.out.println("题目1：字符串反转");
        String str = "Hello World";
        System.out.println("原字符串: " + str);
        
        // 方法1：使用字符数组
        String reversed1 = reverseString1(str);
        System.out.println("反转结果1: " + reversed1);
        
        // 方法2：使用递归
        String reversed2 = reverseString2(str);
        System.out.println("反转结果2: " + reversed2);
        System.out.println();
    }
    
    // 方法1：字符数组反转
    public static String reverseString1(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    // 方法2：递归反转
    public static String reverseString2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        return reverseString2(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * 题目2：查找数组中的重复元素
     * 要求：找出数组中所有重复的元素，时间复杂度O(n)，空间复杂度O(1)
     */
    public static void question2() {
        System.out.println("题目2：查找数组中的重复元素");
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("原数组: " + Arrays.toString(arr));
        
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println("重复元素: " + duplicates);
        System.out.println();
    }
    
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
    
    /**
     * 题目3：判断字符串是否为回文
     * 要求：忽略大小写和标点符号，只考虑字母和数字
     */
    public static void question3() {
        System.out.println("题目3：判断字符串是否为回文");
        String[] testCases = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "Was it a car or a cat I saw?",
            "hello world"
        };
        
        for (String test : testCases) {
            boolean isPalindrome = isPalindrome(test);
            System.out.println("'" + test + "' 是回文: " + isPalindrome);
        }
        System.out.println();
    }
    
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            // 跳过非字母数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // 比较字符（忽略大小写）
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * 题目4：实现单例模式
     * 要求：线程安全的单例模式实现
     */
    public static void question4() {
        System.out.println("题目4：单例模式实现");
        
        // 测试单例
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        
        System.out.println("单例对象是否相同: " + (singleton1 == singleton2));
        System.out.println("单例对象hashCode: " + singleton1.hashCode() + " vs " + singleton2.hashCode());
        System.out.println();
    }
    
    // 线程安全的单例模式
    static class Singleton {
        private static volatile Singleton instance;
        
        private Singleton() {
            // 私有构造函数
        }
        
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
    
    /**
     * 题目5：多线程交替打印
     * 要求：两个线程交替打印数字1-100
     */
    public static void question5() {
        System.out.println("题目5：多线程交替打印（演示前10个数字）");
        
        AlternatingPrinter printer = new AlternatingPrinter();
        
        Thread thread1 = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "偶数线程");
        
        Thread thread2 = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "奇数线程");
        
        thread1.start();
        thread2.start();
        
        // 等待线程完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n多线程打印完成！");
    }
    
    // 交替打印类
    static class AlternatingPrinter {
        private int count = 1;
        private final Object lock = new Object();
        private boolean isOdd = true;
        
        public void printOdd() throws InterruptedException {
            while (count <= 10) {
                synchronized (lock) {
                    while (!isOdd) {
                        lock.wait();
                    }
                    if (count <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        isOdd = false;
                        lock.notify();
                    }
                }
            }
        }
        
        public void printEven() throws InterruptedException {
            while (count <= 10) {
                synchronized (lock) {
                    while (isOdd) {
                        lock.wait();
                    }
                    if (count <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        isOdd = true;
                        lock.notify();
                    }
                }
            }
        }
    }
}
