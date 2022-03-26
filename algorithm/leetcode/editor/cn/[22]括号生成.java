package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(n, res, 0, 0, str);
        return res;
    }

    void dfs(int n, List<String> res, int leftNum, int rightNum, StringBuilder str) {
        // 剪枝
        if (rightNum > leftNum) return;
        if (leftNum == n && rightNum == n) {
            res.add(str.toString());
        }

        if (leftNum < n) {
            str.append("(");
            dfs(n, res, leftNum + 1, rightNum, str);
            str.delete(str.length() - 1, str.length());
        }
        if (rightNum < n) dfs(n, res, leftNum, rightNum + 1, str.append(")"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
