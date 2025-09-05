package com.example.LeetCode.day3;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 解决两个链表代表的数字相加问题
 * 每个链表的节点中包含一个数字，链表从头到尾表示一个整数
 * 链表中的数字按逆序方式存储，即个位在链表的head处
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建哑节点作为结果链表的起始点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;  // 进位

        // 遍历两个链表，直到两个链表都遍历完且没有进位
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前节点的值，若节点为空则取0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // 计算当前位的总和：两个节点值之和加上进位
            int total = val1 + val2 + carry;

            // 计算当前位的值和新的进位
            int currentVal = total % 10;
            carry = total / 10;

            // 创建新节点并添加到结果链表
            current.next = new ListNode(currentVal);
            current = current.next;

            // 移动到下一个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
