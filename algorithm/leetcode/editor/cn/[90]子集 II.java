package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class subsetsWithDupSolution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        if (start == nums.length) return;
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.addLast(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        subsetsWithDupSolution solution = new subsetsWithDupSolution();
//        int[] nums = {1, 2, 2, 2, 3};
        int[] nums = {4,4,4,4};
        System.out.println(solution.subsetsWithDup(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
