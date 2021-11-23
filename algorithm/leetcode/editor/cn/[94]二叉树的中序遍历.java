package leetcode.editor.cn;
import datastructure.TreeNode;

//leetcode submit region begin(Prohibit modification and deletion)

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
class inorderTraversalSolution {
    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    /***
     * 迭代写法，借助栈实现。先访问二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，再开始处理节点。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        inorderTraversalSolution solution = new inorderTraversalSolution();
        TreeNode root = TreeNode.deserialize("5,4,6,1,2,7,8");
//        TreeNode root = TreeNode.deserialize("1,null,2,3,null");
        System.out.println(solution.inorderTraversal(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
