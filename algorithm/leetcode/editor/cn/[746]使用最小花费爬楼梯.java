package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class minCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = cost[0], cur = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int minCost = Math.min(pre, cur) + cost[i];
            pre = cur;
            cur = minCost;
        }
        return Math.min(pre, cur);
    }

    /*public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }*/

    public static void main(String[] args) {
        minCostClimbingStairsSolution solution = new minCostClimbingStairsSolution();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
