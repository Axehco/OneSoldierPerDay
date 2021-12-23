package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class findContentChildrenSolution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int count = 0;
        for (int num : s) {
            if (index == g.length) break;
            if (num >= g[index]) {
                index++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        findContentChildrenSolution solution = new findContentChildrenSolution();
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(solution.findContentChildren(g, s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
