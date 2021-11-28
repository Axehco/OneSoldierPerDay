package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
class levelOrderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cnt = deque.size();  // 控制每一层的输出
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * dfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderdfs(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
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

    public static void main(String[] args) {
        levelOrderSolution solution = new levelOrderSolution();
//        TreeNode root = TreeNode.deserialize("3,9,20,null,null,15,7");
        TreeNode root = TreeNode.deserialize("1,5,4,2,3,6,7");
//        System.out.println(solution.levelOrder(root));
        System.out.println(solution.levelOrderdfs(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
