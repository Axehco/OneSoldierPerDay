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
class findBottomLeftValueSolution {

    /*解法一=========================================================================================*/

    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                // 遍历每一层时，都取第一个值覆盖之前的值，最后得到的一定是此二叉树最底层最左边的节点值
                if (i == 0) res = node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return res;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("1,2,3,null,5,6,null");
        findBottomLeftValueSolution solution = new findBottomLeftValueSolution();
        System.out.println(solution.findBottomLeftValue(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
