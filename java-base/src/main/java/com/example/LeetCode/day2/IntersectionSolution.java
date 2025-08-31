package com.example.LeetCode.day2;


/**
 * 定义链表节点类
 * Java 中单链表节点（ListNode） 的标准定义，用于构建链表这种数据结构
 * */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 解决两个链表相交问题的类
 * 提供一个方法来找到两个链表相交的起始节点
 */
public class IntersectionSolution {
    /**
     * 获取两个链表相交的节点
     * 如果两个链表不相交，则返回null
     *
     * @param headA 第一个链表的头节点
     * @param headB 第二个链表的头节点
     * @return 相交的起始节点，如果不相交则返回null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界条件处理：如果任一任一链表为空，直接返回null
        if (headA == null || headB == null) {
            return null;
        }

        // 初始化两个指针，分别指向两个链表的头节点
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // 当两个指针不相等时继续遍历
        while (pointerA != pointerB) {
            // 指针A到达链表A末尾时，切换到链表B的头节点继续遍历
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // 指针B到达链表B末尾时，切换到链表A的头节点继续遍历
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // 当指针A和指针B相等时，要么是相交节点，要么都是null（没有相交节点）
        return pointerA;
    }

    // 测试方法
    public static void main(String[] args) {
        // 创建测试用的链表
        // 相交节点为值为8的节点
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // 链表A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // 链表B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        IntersectionSolution solution = new IntersectionSolution();
        ListNode result = solution.getIntersectionNode(headA, headB);

        // 输出相交节点的值
        System.out.println("Intersected at '" + result.val + "'");
    }
}
