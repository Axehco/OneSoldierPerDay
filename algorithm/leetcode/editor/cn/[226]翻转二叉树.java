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
class invertTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            // 左子树或右子树有一个不为空，就两两交换位置
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("4,2,7,1,3,6,9");
//        TreeNode root = TreeNode.deserialize("1,null,2,3,4");
        invertTreeSolution solution = new invertTreeSolution();
        System.out.println(solution.invertTree(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
