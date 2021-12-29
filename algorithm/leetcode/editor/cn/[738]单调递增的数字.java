package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class monotoneIncreasingDigitsSolution {
    public int monotoneIncreasingDigits(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int flag = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                flag = i;
                nums[i - 1]--;
            }
        }
        for (int i = flag; i < nums.length; i++) {
            nums[i] = '9';
        }
        /*StringBuilder sb = new StringBuilder();
        for (char num : nums) {
            sb.append(num);
        }
        return Integer.parseInt(sb.toString());*/
        return Integer.parseInt(String.copyValueOf(nums));
    }

    public static void main(String[] args) {
        monotoneIncreasingDigitsSolution solution = new monotoneIncreasingDigitsSolution();
//        System.out.println(solution.monotoneIncreasingDigits1(332));
        System.out.println(solution.monotoneIncreasingDigits(123654));
//        System.out.println(solution.monotoneIncreasingDigits(853567367));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
