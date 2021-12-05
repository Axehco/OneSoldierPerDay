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
class buildTreeSolutionPreAndIn {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 将中序遍历的节点值和索引记录在哈希表中
        for (int i = 0; i < inorder.length; ++i) memo.put(inorder[i], i);
        pre = preorder;
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1);
    }

    /**
     * 根据边界构建树
     * @param is inorderStart
     * @param ie inorderEnd
     * @param ps preorderStart
     * @param pe preorderEnd
     * @return
     */
    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        // 根据前序遍历的结果取得根节点
        int rootvalue = pre[ps];
        // 得到 根节点 在中序遍历数组中的下标。 ri 即 rootIndex.
        int ri = memo.get(rootvalue);
        TreeNode node = new TreeNode(rootvalue);
        // 画图注意边界条件
        node.left = buildTree(is, ri - 1, ps + 1, ps + ri - is);
        node.right = buildTree(ri + 1, ie, ps + ri - is + 1, pe);
        // 注意、返回的是新建立的node
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {4,2,8,5,9,1,6,10,3,7};
        int[] preorder = {1,2,4,5,8,9,3,6,10,7};
        /*int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};*/
        buildTreeSolutionPreAndIn solution = new buildTreeSolutionPreAndIn();
        // toString方法 被重写 层序遍历输出
        System.out.println(solution.buildTree(preorder, inorder));
        TreeNode.preorderTraversal(solution.buildTree(preorder, inorder));
        TreeNode.inorderTraversal(solution.buildTree(preorder, inorder));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
