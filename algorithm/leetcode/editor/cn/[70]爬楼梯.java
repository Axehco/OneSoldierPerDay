package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class climbStairsSolution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

    /*public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    public static void main(String[] args) {
        climbStairsSolution solution = new climbStairsSolution();
        System.out.println(solution.climbStairs(5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
