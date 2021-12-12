package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lowestCommonAncestorSolution {

    /*解法一=========================================================================================*/

    /**
     * 从底往上遍历结点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归边界
        if (p == root || q == root || root == null) return root;

        // 分解为求左子树的子问题和右子树的子问题,注意是后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /*if (left != null && right != null) return root;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return null;*/

        // 简化写法
        /**
         * 如果left和right都不为空，说明此时root就是最近公共节点，返回root
         * 如果left为空，right不为空，就返回right，说明目标节点是通过right返回的
         * 如果left不为空，right为空，就返回left，说明目标节点是通过left返回的
         */
        if (left != null && right != null) return root;
        else if (left == null) return right;
        else return left;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = TreeNode.deserialize("5,6,2,null,null,7,4");
        TreeNode q = TreeNode.deserialize("4");
        // 由于p和q应该是树root中的，所以上述创建方式不对，下面测试结果都会一直是null
        lowestCommonAncestorSolution solution = new lowestCommonAncestorSolution();
        System.out.println(solution.lowestCommonAncestor(root, p, q));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
