package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class restoreIpAddressesSolution {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result;
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int start) {
        // 切割的段数刚好为4或者字符串s已经切割完了，这是达到结束条件
        if (start == 4 || s.length() == 0) {
            if (start == 4 && s.length() == 0) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            /**
             * 切割的每段字符长度必须小于等于3
             * 不能以字符0开头，但是 0.1.2.201 合法
             * 整数范围在0-255之间
             */
            if (temp.length() > 3 || temp.charAt(0) == '0' && temp.length() > 1 || Integer.parseInt(temp) > 255) {
                return;
            }
            // path长度为0 则 temp前面不加'.'
            if (path.length() != 0) {
                temp = "." + temp;
            }
            path.append(temp);
            // 将切割后剩下的字符传入下一层
//            if (s.substring(i + 1).length() > 0) backtracking(s.substring(i + 1), start + 1);
            backtracking(s.substring(i + 1), start + 1);
            // 回溯：删除path中最后 temp
            path.delete(path.length() - temp.length(), path.length());
        }
    }

    public static void main(String[] args) {
        restoreIpAddressesSolution solution = new restoreIpAddressesSolution();
        System.out.println(solution.restoreIpAddresses("255255255255"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
