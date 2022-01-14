package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class intersectSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return res.stream().mapToInt(o1 -> o1).toArray();
    }

    public static void main(String[] args) {
        intersectSolution solution = new intersectSolution();
        solution.intersect(new int[]{2,2,3}, new int[]{4,4,4,9,9,2,2,2,2,});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
