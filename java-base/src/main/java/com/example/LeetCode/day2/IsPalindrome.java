package com.example.LeetCode.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * */
class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

      // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
    // 比较前端和后端的字符是否相等
            if (!vals.get(front).equals(vals.get(back))) {
        // 如果不相等，则说明不是回文，返回false
                return false;
            }
    // 前指针向前移动
            front++;
    // 后指针向后移动
            back--;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome solution = new IsPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(head));
    }
}