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
class trimBSTSolution {

    /*解法一1=========================================================================================*/

    /**
     * 递归
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            // 把该节点左边的节点全部裁掉
            root = root.right;
            // 裁掉之后，继续递归地修剪，重新赋值给root
            root = trimBST(root, low, high);
        }
        else if (root.val > high) {
            // 把该节点右边的节点全部裁掉
            root = root.left;
            // 裁掉之后，继续递归地修剪，重新赋值给root
            root = trimBST(root, low, high);
        }
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }

    /*解法一2=========================================================================================*/

    public TreeNode trimBSTNew(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            TreeNode right = trimBSTNew(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBSTNew(root.left, low, high);
            return left;
        }
        root.left = trimBSTNew(root.left, low, high);
        root.right = trimBSTNew(root.right, low, high);
        return root;
    }

    /*解法二=========================================================================================*/

    /**
     * 迭代
     * 不太好理解！！！
     */
    public TreeNode trimBSTIteration(TreeNode root, int low, int high) {
        if (root == null) return null;
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) root = root.right;
            else root = root.left;
        }
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) cur.left = cur.left.right;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) cur.right = cur.right.left;
            cur = cur.right;
        }
        return root;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("3,0,4,null,2,null,null,1,null");
        int low = 1, high = 3;
        trimBSTSolution solution = new trimBSTSolution();
        System.out.println(solution.trimBST(root, low, high));
        System.out.println(solution.trimBSTIteration(root, low, high));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
