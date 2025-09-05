package com.example.LeetCode.day3;


class TreeNode {
    // 节点值
    int val;
    // 左子节点
    TreeNode left;
    // 右子节点
    TreeNode right;
    // 默认构造函数
    TreeNode() {}
    // 带一个整型参数的构造函数，用于初始化节点值
    TreeNode(int val) { this.val = val; }
    // 带三个参数的构造函数，用于初始化节点值及其左右子节点
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 二叉树的最大深度
 * 计算二叉树的最大深度，即从根节点到最远叶子节点的最长路径上的节点数
 */
public class MaxDepth {
    /**
     * 计算输入二叉树节点的最大深度
     *
     * @param root 二叉树的根节点
     * @return 根节点到最远叶子节点的深度
     */
    public int maxDepth(TreeNode root) {
        // 如果节点为空，说明此路径已结束，返回0
        if (root == null) {
            return 0;
        } else {
            // 递归计算左子树的最大深度
            int leftHeight = maxDepth(root.left);
            // 递归计算右子树的最大深度
            int rightHeight = maxDepth(root.right);
            // 返回较大的子树深度加上当前节点，得到当前路径的深度
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(root));
    }

}
