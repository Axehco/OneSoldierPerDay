package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class wordBreak139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (wordDict.contains(temp) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        wordBreak139Solution solution = new wordBreak139Solution();
        /*List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");*/
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(solution.wordBreak("leetcode", wordDict));

        List<String> wordDict1 = new ArrayList<>(Arrays.asList("apple", "pen"));
        System.out.println(solution.wordBreak("applepenapple", wordDict1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
