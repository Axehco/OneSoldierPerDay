package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class lengthOfLISSolution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLISSolution solution = new lengthOfLISSolution();
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
