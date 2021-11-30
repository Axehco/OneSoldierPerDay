package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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
class isBalancedSolution {
    /**
     * 栈实现前序遍历，对每个节点的左右子树高度进行比较
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Math.abs(getDepth(node.left) - getDepth(node.right)) > 1) return false;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return true;
    }

    /**
     * 求每棵树的高度，也是最大深度
     * @param node
     * @return
     */
    public int getDepth(TreeNode node) {
        if (node == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(node);
        int depth = 0;
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode cur = deque.poll();
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,null,null,null,null,null,null,7");
        isBalancedSolution solution = new isBalancedSolution();
        System.out.println(solution.isBalanced(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
