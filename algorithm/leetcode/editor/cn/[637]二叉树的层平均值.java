package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
class averageOfLevelsSolution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            double sum = 0.0;
            // 遍历每一层，求和
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(sum / cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        averageOfLevelsSolution solution = new averageOfLevelsSolution();
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        System.out.println(solution.averageOfLevels(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
