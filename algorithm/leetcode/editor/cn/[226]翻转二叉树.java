package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.Collections;
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
class invertTreeSolution {
    /**
     * 层序遍历解决、把左右孩子都翻转了，注意翻转的不是值。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            // 左子树或右子树有一个不为空，就两两交换位置
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 递归的方式解决，这里使用的是前序遍历的思想，中左右。后续遍历也可以
     * 但是中序遍历不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     * @param root
     * @return
     */
    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("4,2,7,1,3,6,9");
//        TreeNode root = TreeNode.deserialize("1,null,2,3,4");
        invertTreeSolution solution = new invertTreeSolution();
//        System.out.println(solution.invertTree(root));

        System.out.println(solution.invertTreeRecursion(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
