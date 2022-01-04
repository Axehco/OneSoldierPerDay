package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class lastStoneWeightIISolution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int bagsize = sum / 2;
        int[][] dp = new int[stones.length + 1][bagsize + 1];
        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = 1; j < bagsize + 1; j++) {
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - dp[stones.length][bagsize] - dp[stones.length][bagsize];
    }

    /*public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int bagsize = sum / 2;
        int[] dp = new int[bagsize + 1];
        dp[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = bagsize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[bagsize] - dp[bagsize];
    }*/

    public static void main(String[] args) {
        lastStoneWeightIISolution solution = new lastStoneWeightIISolution();
//        System.out.println(solution.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(solution.lastStoneWeightII(new int[]{1,2}));
//        System.out.println(solution.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
