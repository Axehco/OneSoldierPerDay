package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class sortArraySolution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int mid = nums[(i + j) >> 1];
        while (i < j) {
            while (nums[i] < mid) i++;
            while (nums[j] > mid) j--;
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (left < i) quickSort(nums, left, j);
        if (right > i) quickSort(nums, i, right);
    }

    public static void main(String[] args) {
        sortArraySolution solution = new sortArraySolution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
