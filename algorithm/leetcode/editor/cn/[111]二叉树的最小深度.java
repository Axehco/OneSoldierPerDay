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
class minDepthSolution {
    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            res++;
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                // 找到左子树和右子树都为空时，就找到了最小深度
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        minDepthSolution solution = new minDepthSolution();
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
//        TreeNode root = TreeNode.deserialize("2,null,3,null,4,null,5,null,6");
//        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,7");
        System.out.println(solution.minDepth(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
