package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class solveNQueensSolution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // "." 代表空 "Q"表示皇后，初始化棋盘
        char[][] path = new char[n][n];
        for (int i = 0; i < path.length; i++) {
             Arrays.fill(path[i], '.');
        }
        backtracking(n, 0, path);
        return result;
    }

    public void backtracking(int n, int start, char[][] path) {
        // 每行都成功放置了皇后，记录结果
        if (start == n) {
            List<String> res = new ArrayList<>();
            for (char[] chars : path) {
                res.add(String.valueOf(chars));
            }
            result.add(res);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 排除可以相互攻击的棋子、不能同列、同对角线
            if (!check(n, start, i, path)) {
                continue;
            }
            path[start][i] = 'Q';
            backtracking(n, start + 1, path);
            path[start][i] = '.';
        }
    }

    public boolean check(int n, int row, int col, char[][] path) {
        // 同列
        for (int i = 0; i < row; i++) {
            if (path[i][col] == 'Q') {
                return false;
            }
        }
        // 左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (path[i][j] == 'Q') {
                return false;
            }
        }
        // 右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (path[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueensSolution solution = new solveNQueensSolution();
        System.out.println(solution.solveNQueens(4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
