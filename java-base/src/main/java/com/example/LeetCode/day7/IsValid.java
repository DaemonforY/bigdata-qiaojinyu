package com.example.LeetCode.day7;

/**
 * IsValid 类用于判断字符串中的括号是否有效。
 */
public class IsValid {
    /**
     * 判断字符串中的括号是否有效。
     *
     * @param s 需要判断的字符串，包含括号字符。
     * @return 如果字符串中的括号有效则返回 true；否则返回 false。
     */
    public boolean isValid(String s) {
        // 有效字符串的长度一定是偶数，如果长度为奇数，直接返回 false。
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        // 使用字符数组模拟栈，存储遇到的左括号对应的右括号。
        char[] arr = new char[n];
        // index 表示栈顶索引，初始为 -1 表示栈为空。
        int index = -1;
        // 遍历字符串中的每个字符。
        for (char c : s.toCharArray()) {
            // 如果是左括号，将对应的右括号压入栈中。
            if (c == '(') {
                arr[++index] = ')';
            } else if (c == '[') {
                arr[++index] = ']';
            } else if (c == '{') {
                arr[++index] = '}';
            }
            // 如果是右括号，检查栈是否为空或者栈顶元素是否匹配。
            else if (index == -1 || c != arr[index--]) {
                return false;
            }
        }
        // 遍历结束后栈为空说明所有括号都正确匹配，否则不匹配。
        return index == -1;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        // 测试用例
        System.out.println(isValid.isValid("()[]{}")); // 输出 true
        System.out.println(isValid.isValid("(]"));     // 输出 false
        System.out.println(isValid.isValid("([)]"));   // 输出 false
    }
}
