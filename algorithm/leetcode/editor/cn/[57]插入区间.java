package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class insertSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 先申请一个最大空间存储
        int[][] res = new int[intervals.length + 1][2];
        int start = newInterval[0];
        int end = newInterval[1];
        // 存放结果索引
        int index = 0;
        // 遍历 intervals 的循环变量
        int i = 0;
        // 左边不相交部分
        while (i < intervals.length && intervals[i][1] < start) {
            res[index++] = intervals[i];
            i++;
        }
        // 重叠部分，不断更新 start和end，再加入结果集
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res[index++] = new int[]{start, end};
        // 右边不相交部分
        while (i < intervals.length) {
            res[index++] = intervals[i];
            i++;
        }
        return Arrays.copyOf(res, index);
    }

    // 最后还要排个序，比较耗时，不推荐
    /*public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for (int[] interval : intervals) {
            // 左边相离
            if (newInterval[0] > interval[1]) {
                res.add(new int[]{interval[0], interval[1]});
            } else if (newInterval[1] < interval[0]) {  // 右边相离
                res.add(new int[]{interval[0], interval[1]});
            } else {  // 一定相交的部分
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        res.add(new int[]{start, end});
        int[][] ans =  res.toArray(new int[res.size()][]);
        Arrays.sort(ans, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        return ans;
    }*/

    public static void main(String[] args) {
        insertSolution solution = new insertSolution();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[][] intervals = {{1,2}};
        int[] newInterval = {4,8};
        int[][] res = solution.insert(intervals, newInterval);
        for (int[] re : res) {
            System.out.print(Arrays.toString(re) + " ");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
