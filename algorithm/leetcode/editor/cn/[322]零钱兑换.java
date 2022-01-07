package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class coinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // 将所有的dp赋最大值，因为要找最小值，只要比amount大就行了
        // 金额为0，最小硬币数为0
        dp[0] = 0;
        // 先遍历物品、再遍历背包 都是正序遍历
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        // dp[amount]还是初始化的值，就凑不齐返回-1
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coinChangeSolution solution = new coinChangeSolution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{5}, 11));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
