package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.ArrayList;
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
class pathSumSolution {

    /*解法一=========================================================================================*/

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> pathSum =  new ArrayList<>();
        dfs(root, res, pathSum, targetSum);
        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> res, List<Integer> pathSum, int targetSum) {
        // 终止条件
        if (node == null) return;
        pathSum.add(node.val);
        // 处理：遇到孩子，并且路径和为 targetSum
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (Integer integer : pathSum) {
                sum += integer;
            }
            if (sum == targetSum) {
                /**
                 * 这里是一个易错点
                 * res.add(pathSum); 和 res.add(new ArrayList<>(pathSum)); 区别
                 * res.add(pathSum)： 将res尾部指向了pathSum地址，后续pathSum内容的变化会导致res的变化。
                 * res.add(new ArrayList<>(pathSum))：开辟一个独立地址，地址中存放的内容为pathSum链表，后续pathSum的变化不会影响到res
                 */
                res.add(new ArrayList<>(pathSum));
            }
        }

        if (node.left != null) {
            dfs(node.left, res, pathSum, targetSum);
            pathSum.remove(pathSum.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, res, pathSum, targetSum);
            pathSum.remove(pathSum.size() - 1);
        }
    }

    /*改进=========================================================================================*/

    public List<List<Integer>> pathSumNew(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> pathSum =  new ArrayList<>();
        dfsNew(root, res, pathSum, targetSum);
        return res;
    }

    public void dfsNew(TreeNode node, List<List<Integer>> res, List<Integer> pathSum, int targetSum) {
        // 终止条件
        if (node == null) return;
        pathSum.add(node.val);
        targetSum -= node.val;
        // 处理：遇到孩子，并且路径和为 targetSum
        if (node.left == null && node.right == null && targetSum == 0) {
            res.add(new ArrayList<>(pathSum));
        }

        if (node.left != null) {
            dfsNew(node.left, res, pathSum, targetSum);
            pathSum.remove(pathSum.size() - 1);
        }
        if (node.right != null) {
            dfsNew(node.right, res, pathSum, targetSum);
            pathSum.remove(pathSum.size() - 1);
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("5,4,8,11,null,13,4,7,2,null,null,5,1");
        pathSumSolution solution = new pathSumSolution();
        int targetSum = 22;
        System.out.println(solution.pathSum(root, targetSum));

        System.out.println(solution.pathSumNew(root, targetSum));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
