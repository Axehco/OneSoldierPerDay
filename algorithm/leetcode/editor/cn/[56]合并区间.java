package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class mergeSolution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // 按照开始边界进行排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 没有重叠区间
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else { // 有重叠区间，更新end
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }

    /*public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                res.add(temp);
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        res.add(temp);
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        return ans;
    }*/

    public static void main(String[] args) {
        mergeSolution solution = new mergeSolution();
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,3},{2,6},{8,10},{9,18}};
//        int[][] intervals = {{1,4},{0,4}};
//        int[][] intervals = {{1,4},{2,3}};
        int[][] intervals = {{2,3},{4,5},{6,7},{1,10}};
//        int[][] intervals = {{1,4},{0,4},{3,4},{1,6},{1,8},{2,12}};
        System.out.println(Arrays.toString(solution.merge(intervals)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
