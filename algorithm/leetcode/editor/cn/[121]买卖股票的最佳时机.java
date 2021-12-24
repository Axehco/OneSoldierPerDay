package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class maxProfit121Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                result = Math.max(result, prices[i] - minPrice);
            }
        }
        return result;
    }

    // 暴力 超时！
    /*public int maxProfit(int[] prices) {
        int maxSum = 0;
        for (int i = 0; i < prices.length; i++) {
            int sum = 0;
            for (int j = i; j < prices.length; j++) {
                sum = Math.max(prices[j] - prices[i], sum);
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }*/

    public static void main(String[] args) {
        maxProfit121Solution solution = new maxProfit121Solution();
//        int[] prices = {7,12,1,5,3,6,4};
        int[] prices = {7,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
