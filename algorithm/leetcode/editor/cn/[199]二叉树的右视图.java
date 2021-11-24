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
class rightSideViewSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                // 只需要返回每层的最后节点的值即可
                if (i == cnt - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        rightSideViewSolution solution = new rightSideViewSolution();
        TreeNode root = TreeNode.deserialize("1,2,3,null,5,null,4");
        System.out.println(solution.rightSideView(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
