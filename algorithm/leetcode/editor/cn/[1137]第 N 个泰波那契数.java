package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class tribonacciSolution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int pre = 0, cur = 1, next = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur + next;
            pre = cur;
            cur = next;
            next = sum;
        }
        return next;
    }

    /*public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }*/

    public static void main(String[] args) {
        tribonacciSolution solution = new tribonacciSolution();
        System.out.println(solution.tribonacci(25));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
