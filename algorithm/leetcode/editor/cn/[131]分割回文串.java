package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class partitionSolution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 切割范围： [start, i]
            if (isPalindrome(s, start, i)) {
                // substring 是左闭右开，因此 右边界+1
                path.addLast(s.substring(start, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        partitionSolution solution = new partitionSolution();
        String s = "aab";
        System.out.println(solution.partition(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
