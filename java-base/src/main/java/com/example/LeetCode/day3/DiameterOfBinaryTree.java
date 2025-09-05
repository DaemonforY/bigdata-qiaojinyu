package com.example.LeetCode.day3;

/**
 * 计算二叉树的直径
 * 直径的定义是：二叉树中任意两个节点之间最长路径上的节点数
 * 这个类提供了一个方法来计算给定二叉树的直径
 */
public class DiameterOfBinaryTree {
    // 用于存储最大直径的值
    int ans;

    /**
     * 计算二叉树的直径
     *
     * @param root 二叉树的根节点
     * @return 返回二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // 初始化直径为1，这是至少为1的情况，因为每个节点自身也可以看作是一条路径
        ans = 1;
        // 调用depth方法计算深度并更新直径
        depth(root);
        // 由于直径定义为路径上的节点数减1，所以返回时需要减1
        return ans - 1;
    }

    /**
     * 计算节点的深度，并在计算过程中更新最大直径
     *
     * @param node 当前节点
     * @return 返回当前节点为根的子树的深度
     */
    public int depth(TreeNode node) {
        // 如果节点为空，返回0，表示已经到达边界
        if (node == null) {
            return 0;
        }
        // 递归计算左子树的深度
        int L = depth(node.left);
        // 递归计算右子树的深度
        int R = depth(node.right);
        // 更新最大直径，L+R+1表示当前节点为根的子树的最大直径
        ans = Math.max(ans, L + R + 1);
        // 返回当前节点为根的子树的深度，取左右子树深度的最大值加1
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root));

    }
}
