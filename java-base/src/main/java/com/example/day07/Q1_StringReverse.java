package com.example.day07;

public class Q1_StringReverse {
    public static void main(String[] args) {
        System.out.println("=== 题目1：字符串反转 ===\n");
        System.out.println("题目1：字符串反转");
        String str = "Hello World";
        System.out.println("原字符串: " + str);
        String reversed1 = reverseString1(str);
        System.out.println("反转结果1: " + reversed1);
        String reversed2 = reverseString2(str);
        System.out.println("反转结果2: " + reversed2);
        System.out.println();
    }

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

    public static String reverseString2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseString2(str.substring(1)) + str.charAt(0);
    }
}
