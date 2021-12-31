package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class maxProfit714Solution {
    public int maxProfit(int[] prices, int fee) {
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            // 维护minPrice 相当于买入股票
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] > (minPrice + fee)) {
                result += prices[i] - minPrice - fee;
                // 更新低价，如遇到更高价格，要抵消fee，相当于阶段性的最低买最高卖, 可实现持续累加，最低买最高卖，仅一次手续费
                // 如 [1,6,12,5,10] 中1->6->12只能算1次手续费才是最优的
                minPrice = prices[i] - fee;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        maxProfit714Solution solution = new maxProfit714Solution();
//        int[] prices = {1,3,2,8,4,9};
        int[] prices = {1,7,12,4,9};
        int fee = 2;
        System.out.println(solution.maxProfit(prices, fee));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
