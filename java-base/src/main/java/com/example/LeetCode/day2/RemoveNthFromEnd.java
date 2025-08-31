package com.example.LeetCode.day2;

/**
 * 删除链表的倒数第 N 个结点
 *
 * */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建哑节点，简化边界情况处理（如删除头节点）
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化快慢指针，都指向哑节点
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 让快指针先向前移动n+1步，与慢指针保持n个节点的距离
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 同时移动快慢指针，直到快指针到达链表末尾
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 此时慢指针的下一个节点就是要删除的倒数第n个节点
        slow.next = slow.next.next;

        // 返回新的头节点（哑节点的下一个）
        return dummy.next;
    }

    // 测试代码
    public static void main(String[] args) {
        // 创建示例链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result = solution.removeNthFromEnd(head, 2);

        // 打印结果链表
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // 输出: 1 2 3 5
    }
}
