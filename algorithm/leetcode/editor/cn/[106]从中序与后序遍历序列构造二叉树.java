package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.HashMap;

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
class buildTreeSolution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 将中序遍历的节点值和索引记录在哈希表中
        for (int i = 0; i < inorder.length; ++i) memo.put(inorder[i], i);
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    /**
     * 根据边界构建树
     * @param is inorderStart
     * @param ie inorderEnd
     * @param ps postorderStart
     * @param pe postorderEnd
     * @return
     */
    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        // 根据后序遍历的结果取得根节点
        int rootValue = post[pe];
        // 得到 根节点 在中序遍历数组中的下标。 ri 即 rootIndex.
        int ri = memo.get(rootValue);
        TreeNode node = new TreeNode(rootValue);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        // 注意、返回的是新建立的node
        return node;
    }

    public static void main(String[] args) {
        /*int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};*/
        int[] inorder = {4,2,8,5,9,1,6,10,3,7};
        int[] postorder = {4,8,9,5,2,10,6,7,3,1};
        buildTreeSolution solution = new buildTreeSolution();
        System.out.println(solution.buildTree(inorder, postorder));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
