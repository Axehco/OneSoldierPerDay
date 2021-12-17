package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class combineSolution {

    /**
     * 回溯模板
     * choiceList：当前可以进行的选择列表
     * path：可以理解为决策路径，即已经做出一系列选择
     * result：用来储存我们的符合条件决策路径
     */
    /*void backtracking(choiceList, path, result) {
        if (终止条件) {
            result.add(path)  存放结果;
            return;
        }
        for (choice in choiceList) {
            choose：选择一个 choice 加入 path; 即处理节点;
            backtracking(choiceList, path, result);  即递归
            unchoose：从 path 中撤销上面的选择; 即回溯撤销处理结果
        }
    }*/

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
