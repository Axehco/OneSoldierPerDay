package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class numSquaresSolution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 将所有的dp赋最大值，因为要找最小值，只要比n大就行了
        Arrays.fill(dp,n + 1);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i * i <= j) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    /*public int numSquares(int n) {
        ArrayList<Integer> nums = getNums(n);
        int[] dp = new int[n + 1];
        // 将所有的dp赋最大值，因为要找最小值，只要比n大就行了
        Arrays.fill(dp,n + 1);
        dp[0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i); j < n + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - nums.get(i)] + 1);
            }
        }
        return dp[n];
    }

    public ArrayList<Integer> getNums(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        int index = 1;
        while (index * index <= n) {
            nums.add(index * index);
            index++;
        }
        return nums;
    }*/

    public static void main(String[] args) {
        numSquaresSolution solution = new numSquaresSolution();
        System.out.println(solution.numSquares(13));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
