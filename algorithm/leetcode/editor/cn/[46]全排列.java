package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class permuteSolution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited);
        return result;
    }

    public void backtracking(int[] nums, boolean[] visited) {
        // 终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 每次从头开始搜索
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            path.addLast(nums[i]);
            visited[i] = true;
            backtracking(nums, visited);
            path.removeLast();  // 回溯
            visited[i] = false;  // 回溯
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permuteSolution solution = new permuteSolution();
        System.out.println(solution.permute(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
