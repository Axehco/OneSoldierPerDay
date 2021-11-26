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
class isSymmetricSolution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return true;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = deque.poll();
                // 当前节点是一棵空树，用null代替
                if (node == null) {
                    list.add("null");
                } else {
                    list.add(String.valueOf(node.val));
                    // 左子树是一棵空树也加入队列
                    if (node.left != null) {
                        deque.offer(node.left);
                    } else {
                        deque.offer(null);
                    }
                    // 右子树是一棵空树也加入队列
                    if (node.right != null) {
                        deque.offer(node.right);
                    } else {
                        deque.offer(null);
                    }
                }
            }
            // 判断这一层的树节点构成的集合是否是对称的
            if (!isPalindrome(list)) {
                return false;
            }
        }
        return true;
    }

    // 判断二叉树每层的值构成的集合list是否是对称的/回文的
    public boolean isPalindrome(List<String> list) {
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("1,2,2,null,3,null,3");
//        TreeNode root = TreeNode.deserialize("1,2,2,3,null,null,3");
        isSymmetricSolution solution = new isSymmetricSolution();
        System.out.println(solution.isSymmetric(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
