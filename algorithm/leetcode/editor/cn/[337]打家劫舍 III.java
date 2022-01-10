package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.HashMap;

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
class rob337Solution {
    public int rob(TreeNode root) {
        int[] dp = robHelper(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] robHelper(TreeNode root) {
        if (root == null) return new int[2];
        int[] dp = new int[2];

        int[] left = robHelper(root.left);
        int[] right =  robHelper(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }

    // 记忆化搜索
    /*HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int solution1 = root.val;
        if (root.left != null) {
            solution1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            solution1 += (rob(root.right.left) + rob(root.right.right));
        }
        int solution2 = rob(root.left) + rob(root.right);
        memo.put(root, Math.max(solution1, solution2));
        return Math.max(solution1, solution2);
    }*/

    /*// 暴力解法：超时
    public int rob(TreeNode root) {
        if (root == null) return 0;、
        // solution1:4个孙子+爷爷 solution2：儿子
        int solution1 = root.val;
        if (root.left != null) {
            solution1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            solution1 += (rob(root.right.left) + rob(root.right.right));
        }
        int solution2 = rob(root.left) + rob(root.right);
        return Math.max(solution1, solution2);
    }*/

    public static void main(String[] args) {
        rob337Solution solution = new rob337Solution();
        TreeNode root1 = TreeNode.deserialize("3,2,3,null,3,null,1");
        System.out.println(solution.rob(root1));

        TreeNode root2= TreeNode.deserialize("3,4,5,1,3,null,1");
        System.out.println(solution.rob(root2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
