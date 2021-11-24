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
class largestValuesSolution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            int maxNum = deque.peek().val;
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                if (node.val > maxNum) {
                    maxNum = node.val;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(maxNum);
        }
        return res;
    }

    public static void main(String[] args) {
        largestValuesSolution solution = new largestValuesSolution();
        TreeNode root = TreeNode.deserialize("1,3,2,5,3,null,9");
        System.out.println(solution.largestValues(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
