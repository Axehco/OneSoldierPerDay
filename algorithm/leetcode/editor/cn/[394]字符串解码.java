package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class decodeStringSolution {
    public String decodeString(String s) {
        Stack<String> stack_res = new Stack<>();
        Stack<Integer> stack_multi = new Stack<>();
        StringBuilder res = new StringBuilder();
        int multi  = 0;

        for (Character c : s.toCharArray()) {
            if (c >= '0' && c <= '9') multi = multi  * 10 + (c - '0');
            else if (c == '[') {
                stack_multi.push(multi );
                stack_res.push(res.toString());
                multi  = 0;  // 置0
                res = new StringBuilder();  // 置空
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cnt = stack_multi.pop();
                for (int j = 0; j < cnt; j++) tmp.append(res);
                res = new StringBuilder(stack_res.pop() + tmp);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        decodeStringSolution solution = new decodeStringSolution();
        System.out.println(solution.decodeString("100[leetcode]"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
