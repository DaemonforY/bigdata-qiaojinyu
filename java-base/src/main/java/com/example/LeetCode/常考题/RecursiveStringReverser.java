package com.example.LeetCode.常考题;

public class RecursiveStringReverser {

    /**
     * 递归方式反转字符串
     * @param str 要反转的字符串
     * @return 反转后的字符串
     */
    public static String reverseString(String str) {
        // 递归终止条件：如果字符串为空或只有一个字符，直接返回
        if (str == null || str.length() <= 1) {
            return str;
        }

        // 递归逻辑：
        // 1. 取字符串的最后一个字符
        // 2. 加上对剩余子字符串（除最后一个字符外）的反转结果
        char lastChar = str.charAt(str.length() - 1);
        String remainingSubstring = str.substring(0, str.length() - 1);

        return lastChar + reverseString(remainingSubstring);
    }

    public static void main(String[] args) {
        // 测试用例
        String[] testCases = {
                "Hello",
                "Java",
                "递归反转",
                "",
                "A",
                "abcdefg"
        };

        for (String testCase : testCases) {
            String reversed = reverseString(testCase);
            System.out.println("原始字符串: \"" + testCase + "\"");
            System.out.println("反转后字符串: \"" + reversed + "\"");
            System.out.println("------------------------");
        }
    }
}