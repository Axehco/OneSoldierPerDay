package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class combinationSumSolution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return result;
    }

    void backtracking(int[] candidates, int target, int sum, int start) {
        // 注意这里不是剪枝，因为本题数字可以重复利用，sum > target不返回会导致栈溢出
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) continue;
            path.addLast(candidates[i]);
            sum += candidates[i];
            // 因为数字要重复利用，因此i不做仍和处理
            backtracking(candidates, target, sum, i);
            path.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        combinationSumSolution solution = new combinationSumSolution();
        int[] candidates = {2,7,6,3,5,1};
        int target = 9;
        System.out.println(solution.combinationSum(candidates, target));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
