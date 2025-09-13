package com.example.LeetCode.day9;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 解码字符串类
 * 提供方法将特定格式的编码字符串解码
 */
public class DecodeString {
    // 指针，用于遍历字符串
    int ptr;

    /**
     * 解码字符串的主要方法
     * @param s 编码后的字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        // 使用链表作为栈结构，存储中间结果
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        // 遍历字符串中的每个字符
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母或'['并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                // 遇到']'，开始处理栈内元素
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                // 弹出直到遇到'['的元素，逆序存入sub
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 获取当前子串重复的次数
                int repTime = Integer.parseInt(stk.removeLast());
                // 构造重复的字符串
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        // 将栈内所有字符串连接起来，形成最终结果
        return getString(stk);
    }

    /**
     * 获取连续的数字字符串
     * @param s 原始字符串
     * @return 连续数字组成的字符串
     */
    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    /**
     * 将列表中的字符串连接起来
     * @param v 字符串列表
     * @return 连接后的字符串
     */
    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    /**
     * 主函数，用于测试解码字符串的方法
     */
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        // 测试用例
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
