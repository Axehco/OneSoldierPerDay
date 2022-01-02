package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class fibSolution {
    public int fib(int n) {
        if (n <= 1) return n;
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

    // 带备忘录的解法
    /*public int fib(int n) {
        int[] memo = new int[n + 1];
        return func(n, memo);
    }

    public int func(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }*/

    /*public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    public static void main(String[] args) {
        fibSolution solution = new fibSolution();
        System.out.println(solution.fib(30));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
