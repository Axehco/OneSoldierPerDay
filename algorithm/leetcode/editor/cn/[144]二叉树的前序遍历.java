package leetcode.editor.cn;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
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
class preorderTraversalSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public static void main(String[] args) {
        preorderTraversalSolution solution = new preorderTraversalSolution();
        TreeNode root = TreeNode.deserialize("1,null,2,3,null");
        System.out.println(solution.preorderTraversal(root));
        // 其他测试样例
        /*TreeNode root = TreeNode.deserialize("");
        TreeNode root = TreeNode.deserialize("1,null,null");
        TreeNode root = TreeNode.deserialize("1,2,null");
        TreeNode root = TreeNode.deserialize("1,null,2");*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
