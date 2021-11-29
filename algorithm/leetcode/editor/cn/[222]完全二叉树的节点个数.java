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
class countNodesSolution {
    /**
     * bfs 层序遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                count++;
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
        }
        return count;
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public int countNodesRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftnum = countNodesRecursion(root.left);
        int rightnum = countNodesRecursion(root.right);
        return 1 + leftnum + rightnum;
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,null");
        TreeNode root = TreeNode.deserialize("1,null,2,3,4");  // 不是完全二叉树的情况也可
        countNodesSolution solution = new countNodesSolution();
        System.out.println(solution.countNodes(root));

        System.out.println(solution.countNodesRecursion(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
