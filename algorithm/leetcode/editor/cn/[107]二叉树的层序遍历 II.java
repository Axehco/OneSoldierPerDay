package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.*;

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
class levelOrderBottomSolution {

    /*解法一==========================================================================================*/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }
            res.addFirst(temp);
        }
        return res;
    }

    /*解法二==========================================================================================*/

    /**
     * dfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottomdfs(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    // level代表层数
    public void dfs(TreeNode node, List<List<Integer>> res, int level) {
        // 终止条件
        if (node == null) {
            return;
        }
        // 插入一个空list放到res中
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            dfs(node.left, res, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, res, level + 1);
        }
    }

    /*测试==========================================================================================*/

    public static void main(String[] args) {
        levelOrderBottomSolution solution = new levelOrderBottomSolution();
        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        System.out.println(solution.levelOrderBottom(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
