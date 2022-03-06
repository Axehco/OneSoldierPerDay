package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class findDuplicateSolution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                int index1 = 0;  // 从头开始
                int index2 = slow;  // 在相遇点开始
                // 保证二者走的距离是一样多的，就能求出起始点
                while (index1 != index2) {
                    index1 = nums[index1];
                    index2 = nums[index2];
                }
                return index1;
            }
        }
    }

    public static void main(String[] args) {
        findDuplicateSolution solution = new findDuplicateSolution();
        System.out.println(solution.findDuplicate(new int[]{1, 2, 4, 3, 2}));
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
