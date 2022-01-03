package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class integerBreakSolution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // 0、1的初始化没有意义
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        integerBreakSolution solution = new integerBreakSolution();
        System.out.println(solution.integerBreak(10));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
