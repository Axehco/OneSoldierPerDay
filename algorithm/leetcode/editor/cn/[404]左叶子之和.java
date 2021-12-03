package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
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
class sumOfLeftLeavesSolution {

    /*解法一=========================================================================================*/

    /**
     * 队列实现：层次遍历法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    // 判断是否是左叶子
                    if (node.left.left == null && node.left.right == null) {
                        res += node.left.val;
                    }
                    deque.offer(node.left);
                }
                if (node.right != null) deque.offer(node.right);
            }
        }
        return res;
    }

    /*解法二=========================================================================================*/
    // 递归
    int res = 0;

    public int sumOfLeftLeavesRecursion(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        sumOfLeftLeavesRecursion(root.left);
        sumOfLeftLeavesRecursion(root.right);
        return res;
    }

    /*解法三=========================================================================================*/

    /**
     * 栈实现：前序遍历法
     * @param root
     * @return
     */
    public int sumOfLeftLeavesPre(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    /*解法四=========================================================================================*/

    /**
     * 递归，前中后序遍历都可以
     * @param root
     * @return
     */
    public int sumOfLeftLeavesRecursionPre(TreeNode root) {
        if (root == null) return 0;
        int midsum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midsum = root.left.val;
        }
        int leftsum = sumOfLeftLeavesRecursionPre(root.left);
        int rightsum = sumOfLeftLeavesRecursionPre(root.right);
        return midsum + leftsum + rightsum;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,7");
        sumOfLeftLeavesSolution solution = new sumOfLeftLeavesSolution();
        System.out.println(solution.sumOfLeftLeaves(root));

        System.out.println(solution.sumOfLeftLeavesRecursion(root));

        System.out.println(solution.sumOfLeftLeavesRecursionPre(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
