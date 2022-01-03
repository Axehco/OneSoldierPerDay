package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class canPartitionSolution {
    // 二维dp
    /*public boolean canPartition(int[] nums) {
        int bagsize = 0;
        for (int num : nums) {
            bagsize += num;
        }
        // 和为奇数，一定不能分割
        if (bagsize % 2 == 1) return false;
        bagsize /= 2;
        int[][] dp = new int[nums.length + 1][bagsize + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < bagsize + 1; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[nums.length][bagsize] == bagsize;
    }*/

    // 状态压缩 一维dp
    public boolean canPartition(int[] nums) {
        int bagsize = 0;
        for (int num : nums) {
            bagsize += num;
        }
        // 和为奇数，一定不能分割
        if (bagsize % 2 == 1) return false;
        bagsize /= 2;
        int[] dp = new int[bagsize + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagsize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[bagsize] == bagsize;
    }

    public static void main(String[] args) {
        canPartitionSolution solution = new canPartitionSolution();
//        int[] nums = {1,5,11,5};
        int[] nums = {1,9,3,5};
        System.out.println(solution.canPartition(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
