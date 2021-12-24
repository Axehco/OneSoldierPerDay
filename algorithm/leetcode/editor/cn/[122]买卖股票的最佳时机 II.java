package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class maxProfit122Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        maxProfit122Solution solution = new maxProfit122Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
