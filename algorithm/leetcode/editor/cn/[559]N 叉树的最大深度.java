package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
/*class Node {
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
};*/

/*class Solution {
    public int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            maxDepth++;
            int cnt = deque.size();
            for (int i = 0; i < cnt; ++i) {
                Node node = deque.poll();
                for (Node child: node.children) {
                    deque.offer(child);
                }
            }
        }
        return maxDepth;
    }

}*/
//leetcode submit region end(Prohibit modification and deletion)
