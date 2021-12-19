package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class findSubsequencesSolution {
    // 因为元素比较少，所以可用数组模拟哈希表

    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() > 1) {
            // path中最后一个与前一个比是否是递增的
            if (path.get(path.size() - 1) >= path.get(path.size() - 2)) {
                result.add(new ArrayList<>(path));
            } else {
                return;
            }
        }
        // 题目给出的范围是 [-100,100]，这里多给出了5个位置
        boolean[] visited = new boolean[200 + 5];
        for (int i = start; i < nums.length; ++i) {
            if (i > start && visited[nums[i] + 100]) {
                continue;
            }
            path.add(nums[i]);
            // 因为有负数存在，但是数组下边最小为0，因此 +100
            visited[nums[i] + 100] = true;
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    // LinkedList 用 ArrayList 代替、HashSet平凡插入、计算contains耗时

    /*List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() > 1) {
            if (path.get(path.size() - 1) >= path.get(path.size() - 2)) {
                result.add(new ArrayList<>(path));
            } else {
                return;
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (i > start && visited.contains(nums[i])) continue;
            path.add(nums[i]);
            visited.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }*/

    // LinkedList 在path.get时 效率不高、HashSet平凡插入、计算contains耗时

    /*List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() > 1) {
            if (path.get(path.size() - 1) >= path.get(path.size() - 2)) {
                result.add(new ArrayList<>(path));
            } else {
                return;
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (i > start && visited.contains(nums[i])) continue;
            path.addLast(nums[i]);
            visited.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }*/

    public static void main(String[] args) {
        findSubsequencesSolution solution = new findSubsequencesSolution();
//        int[] nums = {4, 6, 7, 7};
//        int[] nums = {1,2,1,1,4};
//        int[] nums = {4,7,6,7};
        int[] nums = {4,4,3,2,1};
        System.out.println(solution.findSubsequences(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
