package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class findMinArrowShotsSolution {
    public int findMinArrowShots(int[][] points) {
        int cnt = 1;
        // 数组中有负数，注意排序方式，不能直接两个相减 ：o1[1] - o2[1]是错误的
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        long end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            long start = points[i][0];
            if (start > end) {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        findMinArrowShotsSolution solution = new findMinArrowShotsSolution();
//        int[][] points = {{10,16},{5,14},{1,6},{7,12}};
//        int[][] points = {{1,2},{3,4},{4,5},{5,6}};
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(solution.findMinArrowShots(points));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
