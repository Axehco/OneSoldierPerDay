package leetcode.editor.cn;

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class lastStoneWeightSolution {
    public int lastStoneWeight(int[] stones) {
        // 大根堆 (o1, o2) -> o2 - o1
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            if (num1 != num2) {
                pq.offer(num1 - num2);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        lastStoneWeightSolution solution = new lastStoneWeightSolution();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
