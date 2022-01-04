package leetcode.editor.cn;


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class findTargetSumWaysSolution {

    /*一维dp=========================================================================================*/

    /*public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int bagsize = (sum + target) / 2;
        int[] dp = new int[bagsize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagsize; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[bagsize];
    }*/

    /*二维dp=========================================================================================*/

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int bagsize = (sum + target) / 2;
//        if (target > bagsize || bagsize % 2 == 1) {
//            return 0;
//        }
        int[][] dp = new int[nums.length + 1][bagsize + 1];
        // 当背包容量为0，不管装什么物品，填满背包就1种方法
        // 或者说没有任何数字凑出结果0的方式有1种
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < bagsize + 1; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[nums.length][bagsize];
    }

    /*回溯=========================================================================================*/

    /*int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return count;
    }

    public void backtracking(int[] nums,int target, int start, int targetSum) {
        if (start == nums.length) {
            if (targetSum == target) {
                count++;
            }
            return;
        }

        targetSum += nums[start];  // 添加 +
        backtracking(nums, target, start + 1, targetSum);
        targetSum -= nums[start];  // 撤销 + 选择

        targetSum -= nums[start];  // 添加 -
        backtracking(nums, target, start + 1, targetSum);
        targetSum += nums[start];  // 撤销 - 选择
    }*/

    public static void main(String[] args) {
        findTargetSumWaysSolution solution = new findTargetSumWaysSolution();
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
