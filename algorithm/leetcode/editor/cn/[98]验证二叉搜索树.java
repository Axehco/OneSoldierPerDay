package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

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
class isValidBSTSolution {

    /*解法一=========================================================================================*/

    /**
     * 利用二叉搜索树的性质：二叉搜索树的中序遍历是一个递增的序列
     * 因此先得到二叉搜索树的中序遍历序列，再判断该序列是否是递增的即可
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> inorderArray = new LinkedList<>();
        dfs(root, inorderArray);
        System.out.println(inorderArray);
        for (int i = 1; i < inorderArray.size(); i++) {
            // 二叉搜索树不存在重复元素
            if (inorderArray.get(i - 1) >= inorderArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, LinkedList<Integer> inorderArray) {
        if (root == null) return;
        dfs(root.left, inorderArray);
        inorderArray.addLast(root.val);
        dfs(root.right, inorderArray);
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        isValidBSTSolution solution = new isValidBSTSolution();
//        TreeNode root = TreeNode.deserialize("5,1,4,null,null,3,6");
//        TreeNode root = TreeNode.deserialize("2,1,3");
        TreeNode root = TreeNode.deserialize("5,4,6,null,null,3,7");
//        TreeNode root = TreeNode.deserialize("3,1,5,0,2,4,6");
        System.out.println(solution.isValidBST(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
