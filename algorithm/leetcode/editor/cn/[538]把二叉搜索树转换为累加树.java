package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

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
class convertBSTSolution {

    /*解法一=========================================================================================*/

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;  // 记录前面节点的累加和
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();

            cur.val = cur.val + sum;
            sum = cur.val;

            cur = cur.left;
        }
        return root;
    }

    /*解法二=========================================================================================*/

    public TreeNode convertBSTNew(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            sum += cur.val;
            cur = cur.right;
        }
        cur = root;
        int preVal = 0;  // 记录前一个节点的值
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            // 处理逻辑
            sum -= preVal;
            preVal = cur.val;
            cur.val = sum;

            cur = cur.right;
        }
        return root;
    }

    /*解法三=========================================================================================*/

    int sum = 0;

    public TreeNode convertBSTRecursion(TreeNode root) {
        if (root == null) return null;
        convertBSTRecursion(root.right);
        root.val += sum;
        sum = root.val;
        convertBSTRecursion(root.left);
        return root;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("3,2,4,1,null");
        convertBSTSolution solution = new convertBSTSolution();
//        System.out.println(solution.convertBST(root));
//        System.out.println(solution.convertBSTNew(root));
        System.out.println(solution.convertBSTRecursion(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
