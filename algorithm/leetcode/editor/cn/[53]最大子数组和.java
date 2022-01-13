package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class maxSubArraySolution {
    // 动态规划
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // 贪心
    /*public int maxSubArray(int[] nums) {x
        int result = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 记录区间的最大值
            result = Math.max(sum, result);
            // 重置最大子序和的起始位置
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }*/

    // 暴力、Java超时
    /*public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }*/

    public static void main(String[] args) {
        maxSubArraySolution solution = new maxSubArraySolution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(solution.maxSubArray(new int[]{-1,-3,-5,1}));
        System.out.println(solution.maxSubArray(new int[]{-2,1}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
