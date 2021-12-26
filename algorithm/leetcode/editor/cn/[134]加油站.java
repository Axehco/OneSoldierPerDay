package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class canCompleteCircuitSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int[] g = new int[gas.length * 2];
        for (int i = 0; i < gas.length; i++) {
            g[i] = gas[i];
            g[i + gas.length] = gas[i];
        }
        int[] c = new int[cost.length * 2];
        for (int i = 0; i < cost.length; i++) {
            c[i] = cost[i];
            c[i + cost.length] = cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            int len = gas.length;
            int mygas = gas[i];
            int index = i;
            while (len > 0) {
                res = i;
                if (mygas > c[index]) {
                    mygas -= c[index];

                }
            }
        }
        return res;
    }

    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            int mygas = gas[i];
            res = i;
            int cnt = i;
            while (true) {
                int index = 0;
                if (mygas > cost[i]) {
                    mygas -= cost[i];
                    mygas += gas[i];
                    cnt++;
                    index++;
                    if (cnt % gas.length == 0) {
                        cnt = 0;
                    }
                    if (index == gas.length - 1) {
                        break;
                    }
                } else {
                    res = -2;
                    break;
                }
            }
            if (res != -2) {
                break;
            }
        }
        return res;
    }*/

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
