package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class convertToBase7Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        if (num < 0) {  // 负数的情况要额外添加负号
            num = -num;
            flag = true;
        }
        while (num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        if (flag) {
            res.append("-");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        convertToBase7Solution solution = new convertToBase7Solution();
        System.out.println(solution.convertToBase7(100));
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(7));
        System.out.println(solution.convertToBase7(8));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
