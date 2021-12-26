package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class largestSumAfterKNegationsSolution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        // 按照绝对值排序
        list.sort((o1, o2) -> Math.abs(o1) - Math.abs(o2));
		// 从后往前
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < 0 && k > 0) {
                list.set(i, list.get(i) * -1);
                k--;
            }
        }
        // 总的和
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        // 剩余的k是偶数不管，因为偶次数变号相互抵消 奇数要减去最小数的2倍
        if (k % 2 == 1) {
            sum -= list.get(0) * 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        largestSumAfterKNegationsSolution solution = new largestSumAfterKNegationsSolution();
//        int[] nums = {3,-1,0,2};
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        System.out.println(solution.largestSumAfterKNegations(nums, k));
    }
}
//leetcode submit region end(Prohibit modification and deletion)