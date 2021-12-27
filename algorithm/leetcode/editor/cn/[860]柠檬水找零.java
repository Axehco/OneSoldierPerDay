package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class lemonadeChangeSolution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                // 至少有一张5元，找零
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                // 至少有一张5元+一张10元，找零  没有10元则至少有三张5元，找零
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                    twenty++;
                } else if (five >= 3){
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lemonadeChangeSolution solution = new lemonadeChangeSolution();
//        int[] bills = {5,5,5,10,20};
//        int[] bills = {5,5,10,10,20};
        int[] bills = {5,5,5,5,20,20,5,5,20,5};
//        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(solution.lemonadeChange(bills));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
