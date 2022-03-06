package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class longestConsecutiveSolution {
    // 最优解，哈希表
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashTable = new HashSet<>();
        for (int num : nums) {
            hashTable.add(num);
        }
        int res = 0;
        int cnt = 1;
        for (int num : hashTable) {
            if (hashTable.contains(num + 1)) continue;  // 去重，很重要
            while (hashTable.contains(num - 1)) {
                num--;
                cnt++;
            }
            res = Math.max(res, cnt);
            cnt = 1;
        }
        return res;
    }

    // 先排序、再判断
    /*public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {  // 0,1,1,2中间两个1，得到连续升序的序列为0,1,2
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                cnt++;
                res = Math.max(cnt, res);
            } else {
                cnt = 1;
            }
        }
        return res;
    }*/

    // 动态规划 先排序
    /*public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i- 1; j >= 0; j--) {
                if (nums[i] - nums[j] == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/

    public static void main(String[] args) {
        longestConsecutiveSolution solution = new longestConsecutiveSolution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(solution.longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(solution.longestConsecutive(new int[]{1,2,0,1,1,1}));
        System.out.println(solution.longestConsecutive(new int[]{0}));
        System.out.println(solution.longestConsecutive(new int[]{}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
