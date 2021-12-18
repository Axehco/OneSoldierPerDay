package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class findSubsequencesSolution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() > 1) {

        }

        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.addLast(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        findSubsequencesSolution solution = new findSubsequencesSolution();
        int[] nums = {4, 6, 7, 7};
        System.out.println(solution.findSubsequences(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
