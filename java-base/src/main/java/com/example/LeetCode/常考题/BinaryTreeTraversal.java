package com.example.LeetCode.常考题;

import java.util.*;

// 假设TreeNode类定义如下
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
/**
 * 二叉树遍历
 * */
public class BinaryTreeTraversal {

    // 先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    /**
     * 先序遍历辅助方法
     * @param root 当前节点
     * @param res 存储遍历结果的列表
     */
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val); // 先访问当前节点
        preorder(root.left, res); // 再遍历左子树
        preorder(root.right, res); // 最后遍历右子树
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    /**
     * 中序遍历辅助方法
     * @param root 当前节点
     * @param res 存储遍历结果的列表
     */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res); // 先遍历左子树
        res.add(root.val); // 访问当前节点
        inorder(root.right, res); // 最后遍历右子树
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    /**
     * 后序遍历辅助方法
     * @param root 当前节点
     * @param res 存储遍历结果的列表
     */
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res); // 先遍历左子树
        postorder(root.right, res); // 再遍历右子树
        res.add(root.val); // 最后访问当前节点
    }

    /**
     * 层序遍历打印二叉树（按层次输出节点值，直观展示树结构）
     * @param root 二叉树根节点
     * @return 层序遍历的节点值列表（便于打印）
     */
    public List<Integer> levelOrderPrint(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        levelorder(root, result);
        return result;

    }
    public void levelorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return ; // 空树返回空列表
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

    }



    public static void main(String[] args) {
            BinaryTreeTraversal solution = new BinaryTreeTraversal();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            System.out.println("层序遍历结果："+ solution.levelOrderPrint(root));
            System.out.println("先序遍历结果：" + solution.preorderTraversal(root));
            System.out.println("中序遍历结果：" + solution.inorderTraversal(root));
            System.out.println("后序遍历结果：" + solution.postorderTraversal(root));

    }
}
