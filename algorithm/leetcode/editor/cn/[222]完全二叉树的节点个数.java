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
class countNodesSolution {

    /*解法一=========================================================================================*/

    /**
     * bfs 层序遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                count++;
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
        }
        return count;
    }

    /*解法二=========================================================================================*/

    /**
     * 递归写法
     * @param root
     * @return
     */
    public int countNodesRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftnum = countNodesRecursion(root.left);
        int rightnum = countNodesRecursion(root.right);
        return 1 + leftnum + rightnum;
    }

    /*解法三=========================================================================================*/

    /**
     * 如果左子树的深度等于右子树的深度，则左子树为满二叉树
     * 如果左子树的深度大于右子树的深度，则右子树为满二叉树
     * @param root
     * @return
     */
    public int countNodesFeature(TreeNode root) {
        if (root == null) return 0;
        // 以根节点分成左子树和右子树，分别求他们的深度
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return countNodesFeature(root.right) + ((int) Math.pow(2, leftDepth) - 1) + 1;
        } else {
            return countNodesFeature(root.left) + ((int) Math.pow(2, rightDepth) - 1) + 1;
        }
    }

    // 计算深度
    public int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    /*解法四=========================================================================================*/

    public int countNodesFeatureRecursion(TreeNode root) {
        if (root == null) return 0;
        TreeNode lefttree = root.left;
        TreeNode righttree = root.right;
        int leftDepth = 0, rightDepth = 0;
        // 左子树高
        while (lefttree != null) {
            leftDepth++;
            lefttree = lefttree.left;
        }
        // 右子树高
        while (righttree != null) {
            rightDepth++;
            righttree = righttree.right;
        }
        // 左右子树高度相同，则是满二叉树
        // 左右子树高度不相同，则按普通二叉树逻辑计算：根节点+左子树高+右子树高
        // 两个递归只有一个会真正地递归下去，一定会触发 leftDepth == rightDepth 这个条件
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth + 1) - 1;
        } else {
            return 1 + countNodesFeatureRecursion(root.left) + countNodesFeatureRecursion(root.right);
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,null");
        TreeNode root = TreeNode.deserialize("1,2,3,4,5,6,7");
//        TreeNode root = TreeNode.deserialize("1,null,2,3,4");  // 不是完全二叉树的情况也可
        countNodesSolution solution = new countNodesSolution();
        System.out.println(solution.countNodes(root));

        System.out.println(solution.countNodesRecursion(root));

        System.out.println(solution.countNodesFeature(root));

        System.out.println(solution.countNodesFeatureRecursion(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
