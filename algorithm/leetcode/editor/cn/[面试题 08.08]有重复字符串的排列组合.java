package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class permutation0808Solution {
    ArrayList<String> result = new ArrayList<>();

    public String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];
        char[] path = new char[S.length()];

        // 对 字符串S 排序
        /*char[] temp = new char[S.length()];
        for (int i = 0; i < S.length(); i++) {
             temp[i] =  S.charAt(i);
        }
        Arrays.sort(temp);
        StringBuilder sb = new StringBuilder();
        for (char c : temp) {
            sb.append(c);
        }
        backtracking(sb.toString(), visited, path, 0);*/

        // 简化写法
        char[] temp = S.toCharArray();
        Arrays.sort(temp);
        backtracking(new String(temp), visited, path, 0);

        return result.toArray(new String[0]);
    }

    public void backtracking(String S, boolean[] visited, char[] path, int start) {
        if (start == S.length()) {
            result.add(new String(path));
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            // 去重
            if (i > 0 && S.charAt(i) == S.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            path[start] = S.charAt(i);
            visited[i] = true;
            backtracking(S, visited, path, start + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        permutation0808Solution solution = new permutation0808Solution();
        String S = "qqe";
        String[] res = solution.permutation(S);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
