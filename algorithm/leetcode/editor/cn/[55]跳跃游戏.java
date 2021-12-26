package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class canJumpSolution {
    /*public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex >= i) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }*/

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return maxIndex >= nums.length - 1;
    }

    public static void main(String[] args) {
        canJumpSolution solution = new canJumpSolution();
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {1,0,1,0};
//        int[] nums = {3,2,1,0,4};
//        int[] nums = {1,2};
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.canJump(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
