package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class maxSubArraySolution {

    public int maxSubArray(int[] nums) {
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
    }

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
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {5,4,-1,7,8};
        int[] nums = {-1,-3,-5,1};
        System.out.println(solution.maxSubArray(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
