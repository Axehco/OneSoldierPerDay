package leetcode.editor.cn;


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class findTargetSumWaysSolution {

    /*一维dp=========================================================================================*/

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int bagsize = (sum + target) / 2;
        // 加绝对值是：题目种给出的 target可能是一个负数 比如 int[] nums={100}， int target = -200 这种情况
        if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
            return 0;
        }
        int[] dp = new int[bagsize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagsize; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[bagsize];
    }

    /*二维dp=========================================================================================*/

    /*public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int bagsize = (sum + target) / 2;
        if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
            return 0;
        }

        // 定义dp： dp[i][j]表示使用前i个物品, 恰好装满容量为j的背包的方法个数
        // 即：下标为[0,i]的nums[i]能够凑满容量为j的背包，有dp[i][j]种方法。
        int[][] dp = new int[nums.length + 1][bagsize + 1];

        // 边界条件：当背包容量为0，不管装什么物品，填满背包就1种方法
        dp[0][0] = 1;

        // dp数组计算顺序：先遍历物品、再遍历背包
        for (int i = 1; i < nums.length + 1; i++) {
            // 注意这里从0开始 这是与之前写法的区别
            for (int j = 0; j < bagsize + 1; j++) {
                if (j < nums[i - 1]) {  // 容量不够不能装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {  // // 装入背包，但选择 装 与 不装
                    // 当前的方案数应该是装入背包与不装入背包的总和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][bagsize];
    }*/

    /*回溯=========================================================================================*/

    /*int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return count;
    }

    public void backtracking(int[] nums,int target, int start, int targetSum) {
        if (start == nums.length) {
            if (targetSum == target) {
                count++;
            }
            return;
        }

        targetSum += nums[start];  // 添加 +
        backtracking(nums, target, start + 1, targetSum);
        targetSum -= nums[start];  // 撤销 + 选择

        targetSum -= nums[start];  // 添加 -
        backtracking(nums, target, start + 1, targetSum);
        targetSum += nums[start];  // 撤销 - 选择
    }*/

    public static void main(String[] args) {
        findTargetSumWaysSolution solution = new findTargetSumWaysSolution();
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, -5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
