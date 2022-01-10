package leetcode.editor.cn;

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class findKthLargestSolution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            pq.offer(num);
        }
        int index = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            index++;
            if (index == k) {
                return temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findKthLargestSolution solution = new findKthLargestSolution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
