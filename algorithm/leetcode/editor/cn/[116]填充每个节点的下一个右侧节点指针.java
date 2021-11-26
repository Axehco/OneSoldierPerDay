package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
/*// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};*/

class connectSolution {
    /*public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                Node node = deque.poll();
                // 只要当前节点不是每层的最后一个节点，就把当前节点链接到下一个节点
                if (i != cnt - 1) {
                    node.next = deque.peek();
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }*/

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
