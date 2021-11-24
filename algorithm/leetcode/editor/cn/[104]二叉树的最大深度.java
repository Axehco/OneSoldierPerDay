package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
class maxDepthSolution {
    public int maxDepth(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            res++;
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxDepthSolution solution = new maxDepthSolution();
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        System.out.println(solution.maxDepth(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
