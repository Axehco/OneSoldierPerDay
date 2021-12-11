package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class findModeSolution {

    /*解法一=========================================================================================*/

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        /*
        // 以下两种写法均可
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        */
        mapList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        result.add(mapList.get(0).getKey());
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue().equals(mapList.get(0).getValue())) {
                result.add(mapList.get(i).getKey());
            } else {
                break;  // 后面的肯定都不会再相等了
            }
        }
        /*int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            ans[i] = result.get(i);
        }
        return ans;
        Integer[] a = result.toArray(new Integer[result.size()]);*/
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        dfs(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.right, map);
    }

    /*测试=========================================================================================*/

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("1,null,2,2,null");
        TreeNode root = TreeNode.deserialize("1,1,1,2,2,2,3,1,null,2,2,2,2");
        findModeSolution solution = new findModeSolution();
        System.out.println(Arrays.toString(solution.findMode(root)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
