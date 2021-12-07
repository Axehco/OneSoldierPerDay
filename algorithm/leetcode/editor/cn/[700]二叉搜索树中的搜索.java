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
class searchBSTSolution {

    /*解法一=========================================================================================*/

    /**
     * 迭代
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            else if (val < root.val) root = root.left;
            else root = root.right;
        }
        return null;
    }

    /*解法二=========================================================================================*/

    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTRecursion(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) return root;
        /*else if (val < root.val) return searchBSTRecursion(root.left, val);
        else return searchBSTRecursion(root.right, val);*/
        return searchBSTRecursion(val < root.val ? root.left : root.right, val);
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("4,2,7,1,3");
        int val = 2;
        searchBSTSolution solution = new searchBSTSolution();
        System.out.println(solution.searchBST(root, val));
        System.out.println(solution.searchBSTRecursion(root, val));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
