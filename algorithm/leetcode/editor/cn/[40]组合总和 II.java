package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class combinationSum2Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 横向去重 排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    void backtracking(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // candidates 已经排序 这里去重 精髓在于 i > start
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            // 剪枝
            if (sum + candidates[i] > target) continue;
            path.addLast(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i + 1);
            path.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        combinationSum2Solution solution = new combinationSum2Solution();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(solution.combinationSum2(candidates, target));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
