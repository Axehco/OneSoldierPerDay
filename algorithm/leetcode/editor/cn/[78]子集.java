package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class subsetsSolution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        // 其实终止条件要不要都可以
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            path.addLast(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    // 另一种方法
    /*public List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k <= nums.length; ++k) {
            backtracking(nums, k, 0);
        }
        return result;
    }

    private void backtracking(int[] nums, int k, int start) {
        System.out.println(path);
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            path.addLast(nums[i]);
            backtracking(nums, k, i + 1);
            path.removeLast();
        }
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsetsSolution solution = new subsetsSolution();
        System.out.println(solution.subsets(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
