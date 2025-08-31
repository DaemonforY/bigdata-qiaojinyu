package com.example.LeetCode.day2;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 示例 1:
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2:
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3:
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4:
 * 输入：root = [1,2]
 * 输出：[2,1]
 */

/**
 *  Java 中二叉树节点（TreeNode） 的标准定义，
 *  用于构建二叉树这种数据结构。二叉树是一种每个节点最多有两个子节点的树形结构
 * */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InorderTraversal {
    /**
     * 执行中序遍历的主要方法
     * @param root 二叉树的根节点
     * @return 返回中序遍历的结果列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    /**
     * 辅助方法，用于递归地遍历二叉树
     * @param root 当前节点
     * @param res 存储遍历结果的列表
     */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res); // 遍历左子树
        res.add(root.val); // 访问当前节点
        inorder(root.right, res); // 遍历右子树
    }

    public static void main(String[] args) {
        // 构建示例二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderTraversal solution = new InorderTraversal();
        List<Integer> res = solution.inorderTraversal(root);
        System.out.println(res);
    }
}
