package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class permuteUniqueSolution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        // 排序
        Arrays.sort(nums);
        backtracking(nums, visited);
        return result;
    }

    public void backtracking(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 当前元素等于前一个元素、前一个元素的状态已经置为false时 就逃过当前元素。 注意是 visited[i - 1]
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            path.addLast(nums[i]);
            visited[i] = true;
            backtracking(nums, visited);
            path.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permuteUniqueSolution solution = new permuteUniqueSolution();
        System.out.println(solution.permuteUnique(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
