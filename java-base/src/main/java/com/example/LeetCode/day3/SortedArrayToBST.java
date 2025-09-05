package com.example.LeetCode.day3;


import java.util.Arrays;
/**
 * 将有序数组转换为二叉树搜索树
 * 二叉搜索树是一种特殊的二叉树，其左子树上的所有节点的值都小于根节点的值，
 * 右子树上的所有节点的值都大于根节点的值。本类提供了一个方法来将有序数组转换为
 * 高度平衡的二叉搜索树，以满足特定的性能需求或数据结构应用场景。
 */
public class SortedArrayToBST {
    /**
     * 主要方法，接收一个有序数组，将其转换为二叉搜索树的根节点
     *
     * @param nums 有序数组，其中的元素按升序排列
     * @return 转换后的二叉搜索树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 调用辅助方法buildBST来构建二叉搜索树
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * 辅助方法，递归地构建二叉搜索树
     *
     * @param nums 有序数组，其中的元素按升序排列
     * @param left 当前子树在数组中的左边界索引
     * @param right 当前子树在数组中的右边界索引
     * @return 当前子树的根节点
     */
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 当左边界大于右边界时，说明已经遍历完数组，返回null
        if (left > right) {
            return null;
        }

        // 计算当前子树的根节点在数组中的索引，以确保树是平衡的
        int mid = left + (right - left) / 2;
        // 创建当前子树的根节点，并设置其值为数组中间位置的元素
        TreeNode node = new TreeNode(nums[mid]);

        // 递归构建当前根节点的左子树，范围为数组的左半部分
        node.left = buildBST(nums, left, mid - 1);
        // 递归构建当前根节点的右子树，范围为数组的右半部分
        node.right = buildBST(nums, mid + 1, right);

        // 返回构建好的当前子树的根节点
        return node;
    }



    public static void main(String[] args) {
        // 测试示例
        int[] nums = {-10, -3, 0, 5, 9};

        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println("原数组："+ Arrays.toString(nums));
        // 打印二叉树（层序遍历）
        System.out.println("平衡二叉搜索树的层序遍历结果：");
        printTree(root);
    }

    // 辅助方法：层序遍历打印二叉树
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        java.util.List<String> result = new java.util.ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("null");
            }
        }

        // 移除末尾的连续null，使输出更简洁
        int lastIndex = result.size() - 1;
        while (lastIndex >= 0 && result.get(lastIndex).equals("null")) {
            lastIndex--;
        }

        System.out.println(result.subList(0, lastIndex + 1));
    }
}
