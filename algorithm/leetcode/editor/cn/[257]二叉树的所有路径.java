package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
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
class binaryTreePathsSolution {

    /*解法一=========================================================================================*/

    /**
     * 前序遍历，栈来记录节点和路径
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        // 存放节点
        Stack<TreeNode> stack = new Stack<>();
        // 存放路径
        Stack<String> trace = new Stack<>();
        stack.push(root);
        trace.push(String.valueOf(root.val));
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            String path = trace.pop();
            // 左右子树都同时为空，找到叶子节点，输出
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            // 前序遍历，因此入栈顺序是右孩子先入栈
            if (node.right != null) {
                stack.push(node.right);
                trace.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                trace.push(path + "->" + node.left.val);
            }
        }
        return res;
    }

    /*解法二=========================================================================================*/

    public List<String> binaryTreePathsRecursion(TreeNode root) {
        List<String> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();  // 回溯的时候需要移除最后一个元素，因此用链表较快
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode root, LinkedList<String> path, List<String> res) {
        if (root == null) return;
        path.addLast(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
        }
        if (root.left != null) {
            dfs(root.left, path, res);
            // 回溯
//            path.remove(path.size() - 1);
            path.removeLast();
            // 不能这样写：path.remove(path.get(path.size() - 1));
        }
        if (root.right != null) {
            dfs(root.right, path, res);
            path.removeLast();
//            path.remove(path.size() - 1);
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("1,2,3,null,5");
//        TreeNode root = TreeNode.deserialize("1,null,null");
        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,null,null,9,7,null");
        binaryTreePathsSolution solution = new binaryTreePathsSolution();
        System.out.println(solution.binaryTreePaths(root));
        System.out.println(solution.binaryTreePathsRecursion(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
