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
class hasPathSumSolution {

    /*解法一1=========================================================================================*/

    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int pathSum = 0;  // 路径和
        dfs(root,pathSum , targetSum);
        return flag;
    }

    public void dfs(TreeNode node, int pathSum, int targetSum) {
        if (node == null) return;
        pathSum += node.val;
        // 到了叶子节点，并且路径和为 targetSum 结束返回
        if (node.left == null && node.right == null) {
            if (pathSum == targetSum) {
                flag = true;
                return;
            }
        }
        if (node.left != null) {
            // 带有回溯的思想，递归结束后，pathSum的值并没有改变
            dfs(node.left, pathSum, targetSum);
        }
        if (node.right != null) {
            // 带有回溯的思想，递归结束后，pathSum的值并没有改变
            dfs(node.right, pathSum, targetSum);
        }
    }

    /*解法一2=========================================================================================*/

    boolean flagNew = false;

    public boolean hasPathSumNew(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        dfsNew(root, path, targetSum);
        return flagNew;
    }

    public void dfsNew(TreeNode node, List<Integer> path, int targetSum) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (Integer integer : path) {
                sum += integer;
            }
            if (sum == targetSum) {
                flagNew = true;
                return;
            }
        }
        if (node.left != null) {
            dfsNew(node.left, path, targetSum);
            path.remove(path.size() - 1);  // 回溯
        }
        if (node.right != null) {
            dfsNew(node.right, path, targetSum);
            path.remove(path.size() - 1);
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("5,4,8,11,null,13,4,7,2,null,null,null,1");
//        TreeNode root = TreeNode.deserialize("0,1,1");
//        TreeNode root = TreeNode.deserialize("1,2,null");
//        TreeNode root = TreeNode.deserialize("1,2,3,4,5");
        hasPathSumSolution solution = new hasPathSumSolution();
        int targetSum = 22;

//        System.out.println(solution.hasPathSum(root, targetSum));

        System.out.println(solution.hasPathSumNew(root, targetSum));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
