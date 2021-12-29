package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class partitionLabelsSolution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] flag = new int[26];
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(flag[s.charAt(i) - 'a'], end);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        partitionLabelsSolution solution = new partitionLabelsSolution();
        System.out.println(solution.partitionLabels(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
