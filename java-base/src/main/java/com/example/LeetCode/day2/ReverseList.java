package com.example.LeetCode.day2;

/**
 * 反转单链表的实现
 */
public class ReverseList {
    /**
     * 反转给定的单链表
     *
     * @param head 链表的头节点，可能为null
     * @return 反转后的链表的头节点
     */
    public ListNode reverseList(ListNode head) {
        // 初始化三个指针
        ListNode prev = null;    // 指向当前节点的前一个节点
        ListNode current = head; // 指向当前节点
        ListNode next = null;    // 指向当前节点的后一个节点

        // 遍历链表并反转指针
        while (current != null) {
            // 先保存当前节点的下一个节点
            next = current.next;

            // 反转当前节点的指针，使其它指向向前一个节点
            current.next = prev;

            // 将三个指针都向前移动一步
            prev = current;
            current = next;
        }

        // 当循环结束时，prev指向原链表的最后一个节点，即新链表的头节点
        return prev;
    }

    // 测试代码
    public static void main(String[] args) {
        // 创建示例链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 创建ReverseList实例并调用reverseList方法
        ReverseList solution = new ReverseList();
        ListNode reversedHead = solution.reverseList(head);

        // 打印反转后的链表
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // 输出: 5 4 3 2 1
    }
}
