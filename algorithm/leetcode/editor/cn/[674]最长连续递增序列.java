package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class findLengthOfLCISSolution {
    /*public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/

    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        findLengthOfLCISSolution solution = new findLengthOfLCISSolution();
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
