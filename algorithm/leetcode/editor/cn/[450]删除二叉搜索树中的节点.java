package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

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
class deleteNodeSolution {

    /*解法一=========================================================================================*/

    public TreeNode deleteNode(TreeNode root, int key) {
        // 删除的是叶子节点(单个根节点也是叶子节点)，直接删除返回null
        if (root == null) return null;
        // root.val < key 要删除的节点在右子树里面，直接改右子树即可
        if (root.val < key) root.right = deleteNode(root.right, key);
        // root.val > key 要删除的节点在左子树里面，直接改左子树即可
        else if (root.val > key) root.left = deleteNode(root.left, key);
        // 要找的 key 正好是 root.val
        else if (root.val == key) {
            // 既没有左孩子，也没有右孩子，直接删除
            if (root.left == null && root.right == null) return null;
            // 有左子树没有右子树，直接返回左子树
            else if (root.left != null && root.right == null) return root.left;
            // 有右子树没有左子树，直接返回右子树
            else if (root.right != null && root.left == null) return root.right;
            // 待删除的节点既有左树也有右树的情况：先找到右子树中最小值、再交换节点值、再删除交换后右子树里面的key
            else {
                // 找到右子树里面最左边的节点，就是右数里面的最小值
                TreeNode tmp = root.right;
                while (tmp != null && tmp.left != null) {
                    tmp = tmp.left;
                }
                // 交换节点值
                int tempVal = tmp.val;
                tmp.val = root.val;
                root.val = tempVal;
                // 对右子树在进行一次删除操作，因为此时要删除的key已经跑到右子树里面成为最左边的值了
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    /*简化写法=========================================================================================*/

    public TreeNode deleteNodeNew(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNodeNew(root.right, key);
        else if (root.val > key) root.left = deleteNodeNew(root.left, key);
        else {
            if (root.left == null && root.right == null) return null;
            else if (root.left != null && root.right == null) return root.left;
            else if (root.left == null) return root.right;
            else {
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                int tempVal = tmp.val;
                tmp.val = root.val;
                root.val = tempVal;
                root.right = deleteNodeNew(root.right, key);
            }
        }
        return root;
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("5,3,6,2,4,null,7");
        int key = 3;
        deleteNodeSolution solution = new deleteNodeSolution();
        System.out.println(solution.deleteNode(root, key));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
