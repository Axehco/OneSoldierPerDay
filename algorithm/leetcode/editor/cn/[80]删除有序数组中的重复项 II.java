package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class removeDuplicates80Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow - 1] && nums[fast] == nums[slow - 2]) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        removeDuplicates80Solution solution = new removeDuplicates80Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 6}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
