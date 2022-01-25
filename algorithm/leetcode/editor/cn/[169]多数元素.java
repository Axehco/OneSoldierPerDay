package leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class majorityElementSolution {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int voteCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (voteCount == 0) {
                candidate = nums[i];
            }
            if (candidate == nums[i]) {
                voteCount++;
            } else {
                voteCount--;
            }
        }
        return candidate;
    }

    // 摩尔投票法 写法2
    /*public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }*/

    // Map实现类似哈希表功能
    /*public int majorityElement(int[] nums) {
        int targetLen = nums.length / 2;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        int ans = nums[0];
        for (int num : nums) {
            if (memo.get(num) > targetLen) {
                ans = num;
                break;
            }
        }
        return ans;
    }*/

    public static void main(String[] args) {
        majorityElementSolution solution = new majorityElementSolution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[]{3,2,3}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
