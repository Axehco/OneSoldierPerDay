package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class letterCombinationsSolution {
    // 初始化数字、字母映射。本题不用考虑 1 * # 0 等匹配不到字母的情况
    HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    List<String> result = new ArrayList<>();  // 结果
    StringBuilder path = new StringBuilder();  // 路径

    public List<String> letterCombinations(String digits) {
        // 注意边界条件
        if (digits == null || digits.length() == 0) return result;
        backtracking(digits, 0);
        return result;
    }

    void backtracking(String digits, int index) {
        // 终止条件
        if (digits.length() == index) {
            result.add(path.toString());
            return;
        }

        // sb: 当前 index 得到的字符串，如index=2， 则sb为abc
        StringBuilder sb = new StringBuilder(map.get(digits.charAt(index)));
        for (int i = 0; i < sb.length(); ++i) {
            path.append(sb.charAt(i));
            backtracking(digits, index + 1);
            path.deleteCharAt(path.length() - 1);  // 回溯
        }
    }

     //下main这种方法效率不高，主要是定义 path 用了 LinkedList，导致每次在 result.add() 时比较耗时

    /*HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    List<String> result = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        backtracking(digits, 0);
        return result;
    }

    void backtracking(String digits, int index) {
        if (digits.length() == index) {
            StringBuilder temp = new StringBuilder();
            for (Character character : path) {
                temp.append(character);
            }
            result.add(temp.toString());
            return;
        }
        StringBuilder sb = new StringBuilder(map.get(digits.charAt(index)));
        for (int i = 0; i < sb.length(); ++i) {
            path.addLast(sb.charAt(i));
            backtracking(digits, index + 1);
            path.removeLast();
        }
    }*/

    public static void main(String[] args) {
        String digits = "23";
        letterCombinationsSolution solution = new letterCombinationsSolution();
        System.out.println(solution.letterCombinations(digits));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
