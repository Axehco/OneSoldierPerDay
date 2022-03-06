package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class removeDuplicates26Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            }
            else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        removeDuplicates26Solution solution = new removeDuplicates26Solution();
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(solution.removeDuplicates(new int[]{1,1,2}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
