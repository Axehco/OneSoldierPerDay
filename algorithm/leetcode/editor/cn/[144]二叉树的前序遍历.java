package leetcode.editor.cn;
import com.sun.org.apache.bcel.internal.generic.NEW;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
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
class preorderTraversalSolution {
    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    /**
     * 迭代写法，借助栈来完成：入栈顺序：根->右子树->左子树
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode treeNode = stack.peek();
            res.add(treeNode.val);
            stack.pop();
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        preorderTraversalSolution solution = new preorderTraversalSolution();
        TreeNode root = TreeNode.deserialize("1,null,2,3,null");
        System.out.println(solution.preorderTraversal(root));
        // 其他测试样例
        /*TreeNode root = TreeNode.deserialize("");
        TreeNode root = TreeNode.deserialize("1,null,null");
        TreeNode root = TreeNode.deserialize("1,2,null");
        TreeNode root = TreeNode.deserialize("1,null,2");*/

        // 迭代写法调试
        System.out.println(solution.preorderTraversalIteration(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
