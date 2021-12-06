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
class isSameTreeSolution {

    /*解法=========================================================================================*/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
         * 都为空，相同
         * 一个为空、一个非空，不同
         * 两个都非空，但节点值不一样，也不同
         * 再继续递归地比较左、右子树
         */
        if (p == null && q == null) return true;
        else if (p == null || q == null || p.val != q.val) return false;
        else {
            boolean flagLeft = isSameTree(p.left, q.left);
            boolean flaRight = isSameTree(p.right, q.right);
            return flagLeft && flaRight;
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        /*TreeNode p = TreeNode.deserialize("1,2,3");
        TreeNode q = TreeNode.deserialize("1,2,3");*/
        TreeNode p = TreeNode.deserialize("1,null,2");
        TreeNode q = TreeNode.deserialize("1,2,null");
        isSameTreeSolution solution = new isSameTreeSolution();
        System.out.println(solution.isSameTree(p, q));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
