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
class mergeTreesSolution {

    /*解法一=========================================================================================*/

    /**
     * 递归
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    /*解法二=========================================================================================*/

    /**
     * 迭代
     */
    public TreeNode mergeTreesNew(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root1);
        deque.offer(root2);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            node1.val = node1.val + node2.val;
            // 两棵树左节点都不为空、入队列
            if (node1.left != null && node2.left != null) {
                deque.offer(node1.left);
                deque.offer(node2.left);
            }
            // 两棵树右节点都不为空、入队列
            if (node1.right != null && node2.right != null) {
                deque.offer(node1.right);
                deque.offer(node2.right);
            }
            // node1左子树为空、node2左子树不为空
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // node1右子树为空、node2右子树不为空
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.deserialize("1,3,2,5,null");
        TreeNode root2 = TreeNode.deserialize("2,1,3,null,4,7,null");
        mergeTreesSolution solution = new mergeTreesSolution();
        System.out.println(solution.mergeTrees(root1, root2));
        System.out.println(solution.mergeTreesNew(root1, root2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
