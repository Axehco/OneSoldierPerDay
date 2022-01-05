package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class findMaxFormSolution {

    /*一维dp=========================================================================================*/

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            int zeroSum = 0, oneSum = 0;
            for (char c : strs[i - 1].toCharArray()) {
                if (c == '0') zeroSum++;
                else oneSum++;
            }
            for (int j = m; j >= zeroSum; j--) {
                for (int k = n; k >= oneSum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroSum][k - oneSum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /*二维dp=========================================================================================*/

    /*public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            int zeroSum = 0, oneSum = 0;
            for (char c : strs[i - 1].toCharArray()) {
                if (c == '0') zeroSum++;
                else oneSum++;
            }
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j >= zeroSum && k >= oneSum) {
                        dp[i][j][k] = Math.max(dp[i -1][j][k], dp[i - 1][j - zeroSum][k - oneSum] + 1);
                    } else {
                        dp[i][j][k] = dp[i -1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }*/

    /*测试=========================================================================================*/

    public static void main(String[] args) {
        findMaxFormSolution solution = new findMaxFormSolution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
