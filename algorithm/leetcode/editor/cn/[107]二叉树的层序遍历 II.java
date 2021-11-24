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
class levelOrderBottomSolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
            res.addFirst(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        levelOrderBottomSolution solution = new levelOrderBottomSolution();
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        System.out.println(solution.levelOrderBottom(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
