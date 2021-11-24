package utils;

/**
 * @author Axehco
 * @createTime 2021年11月23日 11:02
 */

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现二叉树的前序遍历、中序遍历、后序遍历的统一写法。
 */
public class TreeNodeTraversal {

    /**
     * 前序遍历：中左右 入栈顺序是：右左中
     * @param root 要遍历的树的根节点
     * @return List<Integer>集合
     */
    public static List<Integer> preTraversalOnly(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) { stack.push(node.right); }  // 右
                if (node.left != null) { stack.push(node.left); }  // 左
                stack.push(node);  // 中
                stack.push(null);
            } else {
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    /**
     * 中序遍历：左中右 入栈顺序是：右中左
     * @param root 要遍历的树的根节点
     * @return List<Integer>集合
     */
    public static List<Integer> inTraversalOnly(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) { stack.push(node.right); }  // 右
                stack.push(node);  // 中
                stack.push(null);
                if (node.left != null) { stack.push(node.left); }  // 左
            } else {
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    /**
     * 后序遍历：左右中 入栈顺序是：中右左
     * @param root 要遍历的树的根节点
     * @return List<Integer>集合
     */
    public static List<Integer> postTraversalOnly(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);   // 中
                stack.push(null);
                if (node.right != null) { stack.push(node.right); }  // 右
                if (node.left != null) { stack.push(node.left); }  // 左
            } else {
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.deserialize("5,4,6,1,2,7,8");
//        TreeNode node = TreeNode.deserialize("1,null,2,3,null");
        System.out.println(TreeNodeTraversal.preTraversalOnly(node));
        System.out.println(TreeNodeTraversal.inTraversalOnly(node));
        System.out.println(TreeNodeTraversal.postTraversalOnly(node));
    }
}
