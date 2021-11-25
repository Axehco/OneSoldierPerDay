package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class levelOrderNodeSolution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int cnt = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cnt; ++i) {
                Node node = deque.poll();
                temp.add(node.val);
                // 将所有子孩子放入队列中
                for (Node child: node.children) {
                    deque.offer(child);
                }
                // deque.addAll(node.children);  // 另一种写法
            }
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
