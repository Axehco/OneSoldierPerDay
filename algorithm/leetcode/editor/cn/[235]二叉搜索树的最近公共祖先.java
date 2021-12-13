package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class lowestCommonAncestorBSTSolution {

    /*解法一=========================================================================================*/

    /**
     * 我们从根节点开始遍历；
     * 如果当前节点的值大于`p` 和`q`的值，说明`p` 和`q`应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
     * 如果当前节点的值小于`p` 和`q`的值，说明`p` 和`q`应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
     * 如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，`p`和`q`要么在当前节点的不同的子树中，要么其中一个就是当前节点。直接返回当前节点即可。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        lowestCommonAncestorBSTSolution solution = new lowestCommonAncestorBSTSolution();
        // 由于p和q应该是树root中的，就不测试了，直接在leetcode中调试
        solution.lowestCommonAncestor(new TreeNode(1), new TreeNode(1), new TreeNode(1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
