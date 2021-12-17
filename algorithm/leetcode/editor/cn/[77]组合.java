package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class combineSolution {
    List<List<Integer>> result = new ArrayList<>();  // 储存符合条件决策路径
    LinkedList<Integer> path = new LinkedList<>();  // 决策路径，即已经做出一系列选择

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        /*for (int i = start; i <= n; ++i) {
            path.addLast(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }*/
        // 可以做剪枝操作
        for (int i = start; i <= n - (k - path.size()) + 1; ++i) {
            path.addLast(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        combineSolution solution = new combineSolution();
        System.out.println(solution.combine(n, k));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
