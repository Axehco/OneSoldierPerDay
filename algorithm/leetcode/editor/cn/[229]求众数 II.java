package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class majorityElement229Solution {
    // 摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int candidate1 = 0, voteCount1 = 0;
        int candidate2 = 0, voteCount2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                voteCount1++;
            } else if (num == candidate2) {
                voteCount2++;
            } else if (voteCount1 == 0) {
                candidate1 = num;
                voteCount1 = 1;
            } else if (voteCount2 == 0) {
                candidate2 = num;
                voteCount2 = 1;
            } else {
                voteCount1--;
                voteCount2--;
            }
        }
        voteCount1 = voteCount2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                voteCount1++;
            } else if (num == candidate2) {
                voteCount2++;
            }
        }
        if (voteCount1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (voteCount2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }

    // 哈希表
    /*public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int targetLen = nums.length / 3;
        for (int num : memo.keySet()) {
            if (memo.get(num) > targetLen) {
                res.add(num);
            }
        }
        return res;
    }*/

    public static void main(String[] args) {
        majorityElement229Solution solution = new majorityElement229Solution();
        System.out.println(solution.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
