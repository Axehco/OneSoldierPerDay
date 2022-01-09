package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class rob213Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int solution1 = robfunc(nums, 0, nums.length - 2);
        int solution2 = robfunc(nums, 1, nums.length - 1);
        return Math.max(solution1, solution2);
    }

    public int robfunc(int[] nums, int start, int end) {
        // 只有两个房间的情况
        if (start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        rob213Solution solution = new rob213Solution();
        System.out.println(solution.rob(new int[]{1,2,3}));
        System.out.println(solution.rob(new int[]{2,3,2}));
        System.out.println(solution.rob(new int[]{1,2,3,1}));
        System.out.println(solution.rob(new int[]{1,6,1,9,1}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
