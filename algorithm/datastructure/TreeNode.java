package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Axehco
 * @createTime 2021年11月22日 21:33
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode deserialize(String data) {
        return buildTree(data, ",", "null");
    }

    /**
     * 通过字符串构造二叉树，注意保证只要有左子树或右子树存在时，就必须完整写出左右子树，null都不能省略，注意不要有多余的空格
     * @param data 字符传
     * @param sep 分隔符
     * @param isNULL 左子树或右子树为空的标记
     * @return 二叉树根节点
     */
    public static TreeNode buildTree(String data, String sep, String isNULL) {
        if (data.isEmpty()) return null;
        String[] values = data.split(sep);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < values.length;) {
            TreeNode cur = queue.poll();
            String temp1 = values[i++];
            if (!temp1.equals(isNULL)) {
                cur.left = new TreeNode(Integer.parseInt(temp1));
                queue.offer(cur.left);
            } else {
                cur.left = null;
            }

            String temp2 = values[i++];
            if (!temp2.equals(isNULL)) {
                cur.right = new TreeNode(Integer.parseInt(temp2));
                queue.offer(cur.right);
            } else {
                cur.right = null;
            }
        }
        return root;
    }

    /**
     * 前序遍历
     * @param root 根节点
     */
    public static void preorderTraversal(TreeNode root) {
        System.out.print("Preorder Traversal: ");
        List<Integer> res = new ArrayList<>();
        preorderTraversalcur(root, res);
        System.out.println(res);
    }

    private static void preorderTraversalcur(TreeNode root, List<Integer> res) {
        if (root == null) { return; }
        res.add(root.val);
        preorderTraversalcur(root.left, res);
        preorderTraversalcur(root.right, res);
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    public static void inorderTraversal(TreeNode root) {
        System.out.print("Inorder Traversal: ");
        List<Integer> res = new ArrayList<>();
        inorderTraversalcur(root, res);
        System.out.println(res);
    }

    private static void inorderTraversalcur(TreeNode root, List<Integer> res) {
        if (root == null) { return; }
        inorderTraversalcur(root.left, res);
        res.add(root.val);
        inorderTraversalcur(root.right, res);
    }

    /**
     * 后续遍历
     * @param root 根节点
     */
    public static void postorderTraversal(TreeNode root) {
        System.out.print("Postorder Traversal: ");
        List<Integer> res = new ArrayList<>();
        postorderTraversalcur(root, res);
        System.out.println(res);
    }

    private static void postorderTraversalcur(TreeNode root, List<Integer> res) {
        if (root == null) { return; }
        postorderTraversalcur(root.left, res);
        postorderTraversalcur(root.right, res);
        res.add(root.val);
    }

    /**
     * 层次遍历
     * @param root 根节点
     */
    public static void levelTraverse(TreeNode root) {
        System.out.print("Levelorder Traversal: ");
        List<String> res = levelTraverseBFS(root);
        System.out.println(res);
    }

    private static List<String> levelTraverseBFS(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }
        List<String> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(String.valueOf(node.val));
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return levelTraverseBFS(this).toString();
    }

    public static void main(String[] args) {
        TreeNode root = deserialize("1,null,2,3,null");
        System.out.println(root);
        preorderTraversal(root);
        inorderTraversal(root);
        postorderTraversal(root);
    }
}
