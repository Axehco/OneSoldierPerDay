package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class wiggleMaxLengthSolution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pre = nums[1] - nums[0];
        // 前两个数相同初始化res为1，不相同则初始化res为2
        int res = pre == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; ++i) {
            int cur = nums[i] - nums[i - 1];
            if (pre >= 0 && cur < 0 || pre <= 0 && cur > 0) {
                res++;
                pre = cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        wiggleMaxLengthSolution solution = new wiggleMaxLengthSolution();
//        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
//        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        int[] nums = {9,8,7,6,5,4,3};
//        int[] nums = {1,7,4,9,2,5};
//        int[] nums = {1,7,8,9,10,7,1};
        int[] nums = {3,3,3,2,5};
//        int[] nums = {0,1,1,1,1,0};
        System.out.println(solution.wiggleMaxLength(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
