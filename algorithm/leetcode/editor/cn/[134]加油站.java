package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class canCompleteCircuitSolution {
    // 暴力、超时
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) continue;
            int len = gas.length;
            int mygas = gas[i];
            int index = i;
            res = i;
            while (len > 0) {
                if (mygas >= cost[index]) {
                    mygas -= cost[index];
                    index++;
                    if (index % gas.length == 0) index = 0;
                    mygas += gas[index];
                    len--;
                } else {
                    res = -1;
                    break;
                }
            }
            if (res != -1) break;
        }
        return res;
    }

    public static void main(String[] args) {
        canCompleteCircuitSolution solution = new canCompleteCircuitSolution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
