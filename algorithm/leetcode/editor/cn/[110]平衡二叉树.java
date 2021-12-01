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
class isBalancedSolution {

    /*解法一=========================================================================================*/

    /**
     * 栈实现前序遍历，对每个节点的左右子树高度进行比较
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Math.abs(getDepth(node.left) - getDepth(node.right)) > 1) return false;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return true;
    }

    /**
     * 求每棵树的高度【从该节点到叶子节点的最长简单路径边的条数】，也是整棵树的最大深度【从根节点到该节点的最长简单路径边的条数】
     * @param node
     * @return
     */
    public int getDepth(TreeNode node) {
        if (node == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(node);
        int depth = 0;
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode cur = deque.poll();
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    /*解法二=========================================================================================*/

    /**
     * 递归，求高度(从该节点到叶子节点的最长简单路径边的条数)，用后序遍历的思想 左右中，先求左右子树的高度 再判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalancedRecursion(TreeNode root) {
//       return getHeight(root) == -1 ? false : true;
       return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        // 递归终止条件
        if (node == null) return 0;

        // 不平衡的情况有3种：左树不平衡、右树不平衡、左树和右树差的绝对值大于1，这里用-1来标记此时已经不是一棵平衡二叉树了，就没必要往下继续走了。如果上述情况都满足，说明平衡了，树的深度为左右俩子树最大深度+1
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
//        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,null,null,null,null,null,null,7");
        isBalancedSolution solution = new isBalancedSolution();
        System.out.println(solution.isBalanced(root));
        System.out.println(solution.isBalancedRecursion(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
