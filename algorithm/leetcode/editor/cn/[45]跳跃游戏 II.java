package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class jumpSolution {
    public int jump(int[] nums) {
        int curMaxIndex = 0;  // 目前能跳到的最远位置
        int nextMaxIndex = 0;  // 上次跳跃可达范围右边界（下次的最右起跳点）
        int step = 0;  // 跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            curMaxIndex = Math.max(i + nums[i], curMaxIndex);
            // 到达上次跳跃能到达的右边界了
            if (i == nextMaxIndex) {
                // 进入下一次跳跃
                step++;
                // 目前能跳到的最远位置变成了下次起跳位置的右边界
                nextMaxIndex = curMaxIndex;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        jumpSolution solution = new jumpSolution();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.jump(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
