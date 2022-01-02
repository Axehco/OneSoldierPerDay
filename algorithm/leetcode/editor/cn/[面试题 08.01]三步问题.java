package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class waysToStepSolution {
    public int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        long pre = 1, cur = 2, next = 4;
        for (int i = 4; i <= n; i++) {
            long sum = (pre + cur + next) % 1000000007;
            pre = cur;
            cur = next;
            next = sum;
        }
        return (int)next;
    }

    public static void main(String[] args) {
        waysToStepSolution solution = new waysToStepSolution();
        System.out.println(solution.waysToStep(61));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
