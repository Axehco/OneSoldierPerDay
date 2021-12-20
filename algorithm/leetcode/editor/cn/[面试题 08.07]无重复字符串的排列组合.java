package leetcode.editor.cn;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class permutation0807Solution {
    ArrayList<String> result = new ArrayList<>();

    public String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];
        char[] path = new char[S.length()];
        backtracking(S, path, visited, 0);
        return result.toArray(new String[0]);
    }

    public void backtracking(String S, char[] path, boolean[] visited, int start) {
        if (start == S.length()) {
            result.add(new String(path));
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (visited[i]) {
                continue;
            }
            path[start] = S.charAt(i);
            visited[i] = true;
            backtracking(S, path, visited, start + 1);
            visited[i] = false;
        }
    }

    // 此解法使用 StringBuilder path 相对耗时， 有append和deleteCharAt 相对耗时

    /*ArrayList<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];
        backtracking(S, visited);
        return result.toArray(new String[0]);
    }

    void backtracking(String S, boolean[] visited) {
        if (path.length() == S.length()) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (visited[i]) {
                continue;
            }
            path.append(S.charAt(i));
            visited[i] = true;
            backtracking(S, visited);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }*/

    public static void main(String[] args) {
        String S = "qwe";
        permutation0807Solution solution = new permutation0807Solution();
        String[] res = solution.permutation(S);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
