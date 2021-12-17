package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class combinationSum3Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    public void backtracking(int k, int n, int start, int sum) {
        // 剪枝
        if (sum > n) return;
        if (path.size() == k) {
            if (sum == n) result.add(new ArrayList<>(path));
            // 如果path.size() == k 且 sum == n 找到符合条件的路径 返回
            // 如果path.size() == k 但 sum != n 也直接返回，没有必要往下了
            return;
        }

        // 剪枝
        for (int i = start; i <= 9 - (k - path.size()) + 1; ++i) {
            path.addLast(i);
            sum += i;
            backtracking(k, n, i + 1, sum);
            path.removeLast();  // 回溯
            sum -= i;  // 回溯
        }
    }

    /*public void backtracking(int k, int n, int start) {
        if (path.size() == k) {
            int sum = 0;
            for (Integer integer : path) {
                sum += integer;
            }
            if (sum == n) {
                result.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = start; i <= 9; ++i) {
            path.addLast(i);
            backtracking(k, n, i + 1);
            path.removeLast();
        }
    }*/

    public static void main(String[] args) {
        int k = 3, n = 9;
        combinationSum3Solution solution = new combinationSum3Solution();
        System.out.println(solution.combinationSum3(k, n));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
