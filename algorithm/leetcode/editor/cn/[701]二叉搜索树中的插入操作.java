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
class insertIntoBSTSolution {

    /*解法一=========================================================================================*/

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                else cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                else cur = cur.left;
            }
        }
        return root;
    }

    /*解法二=========================================================================================*/

    public TreeNode insertIntoBSTRecursion(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertIntoBSTRecursion(root.right, val);
        if (root.val > val) root.left = insertIntoBSTRecursion(root.left, val);
        return root;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("4,2,7,1,3");
        TreeNode root = TreeNode.deserialize("8,null,55,39,null,11,null,null,23");
        int val = 17;
        insertIntoBSTSolution solution = new insertIntoBSTSolution();
        System.out.println(solution.insertIntoBST(root, val));
        System.out.println(solution.insertIntoBSTRecursion(root, val));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
