package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
class maxDepthSolution {

    /*解法一=========================================================================================*/

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            res++;
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
        }
        return res;
    }

    /*解法二==========================================================================================*/

    /**
     * 递归，后续遍历的方式
     * @param root
     * @return
     */
    public int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepthRecursion(root.left);
        int rightMaxDepth = maxDepthRecursion(root.right);
        return leftMaxDepth > rightMaxDepth ? leftMaxDepth + 1 : rightMaxDepth + 1;
    }

    /*解法三==========================================================================================*/

    /**
     * 回溯思想
     */
    int result = 0;  // 存储答案的全局变量

    public int maxDepthBacktracking(TreeNode root) {
        if (root == null) {
            return result;
        }
        backTracking(root, 1);
        return result;
    }

    public void backTracking(TreeNode node, int depth) {
        result = Math.max(depth, result);
        // 终止条件
        if (node.left == null && node.right == null) return;
        // 回溯的思想
        if (node.left != null) {
            depth++;
            backTracking(node.left, depth);
            depth--;
        }
        if (node.right != null) {
            depth++;
            backTracking(node.right, depth);
            depth--;
        }
    }

    /*测  试==========================================================================================*/

    public static void main(String[] args) {
        maxDepthSolution solution = new maxDepthSolution();
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
//        TreeNode root = TreeNode.deserialize("2,null,3,null,4,null,5,null,6");
        System.out.println(solution.maxDepth(root));
        System.out.println(solution.maxDepthRecursion(root));
        System.out.println(solution.maxDepthBacktracking(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
