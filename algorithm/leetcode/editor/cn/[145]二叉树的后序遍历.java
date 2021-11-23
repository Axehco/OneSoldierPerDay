package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class postorderTraversalSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tempNode = stack.peek();
            res.add(tempNode.val);
            stack.pop();
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 实际上不是迭代的思想了，借助队列完成，不需要像栈一样进行最后的reverse，每次addFirst时间复杂度都是O(1)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalDeque(TreeNode root) {
        // 存放结果也用LinkedList，每次在队首插入
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) { return res; }
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            res.addFirst(node.val);
            if (node.left != null) {
                deque.addFirst(node.left);
            }
            if (node.right != null) {
                deque.addFirst(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        postorderTraversalSolution solution = new postorderTraversalSolution();
        TreeNode root = TreeNode.deserialize("5,4,6,1,2,7,8");
        System.out.println(solution.postorderTraversal(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
