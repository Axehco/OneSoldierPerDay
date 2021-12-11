package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

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
class constructMaximumBinaryTreeSolution {

    /*解法一=========================================================================================*/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    // 在区间 [left,right] 内构建树
    public TreeNode constructTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = getMaxIndex(nums, left, right);
        // nums中区间 [left,right] 内的最大值作为根节点构造二叉树
        TreeNode node = new TreeNode(nums[maxIndex]);
        // 递归地构造左右子树
        node.left = constructTree(nums, left, maxIndex - 1);
        node.right = constructTree(nums, maxIndex + 1, right);
        return node;
    }

    // 在 nums 中求 [left,right] 区间内的最大值索引
    public int getMaxIndex(int[] nums, int left, int right) {
        int index = left;
        for (int i = left; i <= right; ++i) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTreeSolution solution = new constructMaximumBinaryTreeSolution();
        System.out.println(solution.constructMaximumBinaryTree(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
