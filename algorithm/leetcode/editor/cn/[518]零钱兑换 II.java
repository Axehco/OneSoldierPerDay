package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class changeSolution {

    /*一维dp=========================================================================================*/

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /*二维dp=========================================================================================*/

    /*public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }*/

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        changeSolution solution = new changeSolution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change(3, new int[]{2}));
        System.out.println(solution.change(10, new int[]{10}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
