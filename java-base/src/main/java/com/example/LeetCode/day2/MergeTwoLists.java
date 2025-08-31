package com.example.LeetCode.day2;
/**
 * 合并两个有序列表
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * */
public class MergeTwoLists{
  /**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回新链表的头节点
 * 该方法使用递归方式合并，比较两个链表的当前节点，选择值较小的节点作为新链表的节点
 *
 * @param l1 第一个有序链表的头节点
 * @param l2 第二个有序链表的头节点
 * @return 合并后的有序链表的头节点
 */
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 如果第一个链表为空，则直接返回第二个链表
    if (l1 == null) {
        return l2;
    } else if (l2 == null) {
        // 如果第二个链表为空，则直接返回第一个链表
        return l1;
    } else if (l1.val < l2.val) {
        // 如果第一个链表的当前节点值小于第二个链表的当前节点值，
        // 则选择第一个链表的节点作为新链表的节点，并递归地合并两个链表的其余部分
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        // 如果第二个链表的当前节点值小于等于第一个链表的当前节点值，
        // 则选择第二个链表的节点作为新链表的节点，并递归地合并两个链表的其余部分
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


}
