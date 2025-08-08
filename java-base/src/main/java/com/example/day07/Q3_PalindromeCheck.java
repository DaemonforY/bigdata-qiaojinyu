package com.example.day07;

public class Q3_PalindromeCheck {
    public static void main(String[] args) {
        System.out.println("=== 题目3：判断字符串是否为回文 ===\n");
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
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
