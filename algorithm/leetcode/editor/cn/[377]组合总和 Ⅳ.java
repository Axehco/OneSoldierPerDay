package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class combinationSum4Solution {

    /*一维dp=========================================================================================*/

    /*public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j < target + 1; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }*/

    /*二维dp=========================================================================================*/
    // 这里是借鉴别人的
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int[][] dp = new int[target + 1][nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (i < nums[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i - nums[k]][j];
                    }
                }
            }
        }
        return dp[target][nums.length];
    }

    public static void main(String[] args) {
        combinationSum4Solution solution = new combinationSum4Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));  // 7
        System.out.println(solution.combinationSum4(new int[]{9}, 3));  // 0
        System.out.println(solution.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,
                23,24,25}, 10));  // 9
    }
}
//leetcode submit region end(Prohibit modification and deletion)
