package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class rob198Solution {
    /*public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }*/

    /*public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }*/

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tempMax = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = tempMax;
        }
        return cur;
    }

    public static void main(String[] args) {
        rob198Solution solution = new rob198Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{8, 7}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
