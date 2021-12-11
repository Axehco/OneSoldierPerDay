package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class getMinimumDifferenceSolution {

    /*解法一=========================================================================================*/

    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorderArray = new ArrayList<>();
        dfs(root, inorderArray);
        int res = Math.abs(inorderArray.get(1) - inorderArray.get(0));
        for (int i = 1; i < inorderArray.size(); ++i) {
            res = Math.min(Math.abs(inorderArray.get(i) - inorderArray.get(i - 1)), res);
        }
        return res;
    }

    public void dfs(TreeNode root,List<Integer> inorderArray) {
        if (root == null) return;
        dfs(root.left, inorderArray);
        inorderArray.add(root.val);
        dfs(root.right, inorderArray);
    }

    /*解法二=========================================================================================*/

    int pre = Integer.MAX_VALUE;  // 记录树中序遍历上一个节点的值

    public int getMinimumDifferenceIteration(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res = Math.min(Math.abs(root.val - pre), res);
            pre = root.val;
            root = root.right;
        }
        return res;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("1,0,48,null,null,12,49");
        TreeNode root = TreeNode.deserialize("4,2,6,1,3");
        getMinimumDifferenceSolution solution = new getMinimumDifferenceSolution();
        System.out.println(solution.getMinimumDifference(root));
        System.out.println(solution.getMinimumDifferenceIteration(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
