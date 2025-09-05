package com.example.LeetCode.day3;
//翻转二叉树

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertTree{
    /**
     * 翻转二叉树方法
     *
     * @param root 二叉树的根节点
     * @return 翻转后的二叉树的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        // 基线条件：如果节点为空，直接返回
        if (root == null) {
            return null;
        }

        // 递归翻转左子树
        TreeNode left = invertTree(root.left);
        // 递归翻转右子树
        TreeNode right = invertTree(root.right);

        // 交换当前节点的左右子树
        root.left = right;
        root.right = left;

        // 返回当前节点
        return root;
    }


    /**
     * 层序遍历打印二叉树（按层次输出节点值，直观展示树结构）
     * @param root 二叉树根节点
     * @return 层序遍历的节点值列表（便于打印）
     */
    public List<Integer> levelOrderPrint(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // 空树返回空列表
        }

        // 用队列实现层序遍历（先进先出，保证按层处理节点）
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 根节点入队

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // 当前节点出队
            result.add(current.val); // 记录当前节点值

            // 左子节点非空则入队
            if (current.left != null) {
                queue.offer(current.left);
            }
            // 右子节点非空则入队
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InvertTree solution = new InvertTree();

        // 1. 构建示例二叉树（
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // 2. 打印翻转前的二叉树
        System.out.println("翻转前的二叉树（层序遍历）：" + solution.levelOrderPrint(root));

        // 3. 执行翻转操作
        TreeNode invertedRoot = solution.invertTree(root);

        // 4. 打印翻转后的二叉树
        System.out.println("翻转后的二叉树（层序遍历）：" + solution.levelOrderPrint(invertedRoot));
    }
}

