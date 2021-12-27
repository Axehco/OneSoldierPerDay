package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class eraseOverlapIntervalsSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        // 按照结束区间排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start < end) {
                res++;
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        eraseOverlapIntervalsSolution solution = new eraseOverlapIntervalsSolution();
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{1,2},{1,2},{1,2}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
