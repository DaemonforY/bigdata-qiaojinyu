package com.example.LeetCode.day2;
/**
 * 判断链表中是否有环。
 * */
public class HasCycle{
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        // 初始化快慢指针
        ListNode slow = head;  // 慢指针，每次移动1步
        ListNode fast = head.next;  // 快指针，每次移动2步

        // 当快慢指针不相遇时继续遍历
        while (slow != fast) {
            // 如果快指针到达链表末尾，说明无环
            if (fast == null || fast.next == null) {
                return false;
            }

            // 移动指针：慢指针1步，快指针2步
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果快慢指针相遇，说明有环
        return true;
    }

    public static void main(String[] args) {
        HasCycle solution = new HasCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(solution.hasCycle(head));

    }
}