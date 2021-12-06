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
class isSubtreeSolution {

    /*解法=========================================================================================*/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 递归终止条件
        if (root == null) return false;

        boolean flag = compareTwoTree(root, subRoot);
        if (flag) return true;
        boolean flagLeft = isSubtree(root.left, subRoot);
        if (flagLeft) return true;
        boolean flagRight = isSubtree(root.right, subRoot);
        if (flagRight) return true;

        // root递归完后都没找到匹配的
        return false;
    }

    // 相同、表示找到了 返回true
    public boolean compareTwoTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null || p.val != q.val) return false;
        else return compareTwoTree(p.left, q.left) && compareTwoTree(p.right, q.right);
    }

    /*优化=========================================================================================*/

    public boolean isSubtreeNew(TreeNode root, TreeNode subRoot) {
        // 递归终止条件
        if (root == null) return false;
        return compareTwoTreeNew(root, subRoot) || isSubtreeNew(root.left, subRoot) || isSubtreeNew(root.right, subRoot);
    }

    // 相同、表示找到了 返回true
    public boolean compareTwoTreeNew(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null || p.val != q.val) return false;
        else return compareTwoTree(p.left, q.left) && compareTwoTree(p.right, q.right);
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("3,4,5,1,2");
//        TreeNode subRoot = TreeNode.deserialize("4,1,2");
        TreeNode root = TreeNode.deserialize("3,4,5,1,2,null,null,null,null,0,null");
        TreeNode subRoot = TreeNode.deserialize("4,1,2");
        isSubtreeSolution solution = new isSubtreeSolution();
        System.out.println(solution.isSubtree(root, subRoot));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
