import java.util.*;

import datastructure.TreeNode;

/**
 * @author Axehco
 * @createTime 2021年11月23日 9:25
 */
public class MainTest {
    public static void main(String[] args) {
        /*int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;*/
        int[] weight = {2,3,4,7};
        int[] value = {1,3,5,9};
        int bagSize = 10;
        /*int[] weight = {2,3,4,5};
        int[] value = {3,4,5,8};
        int bagSize = 8;*/
//        knapsack(weight, value, bagSize);
//        knapsack1(weight, value, bagSize);
//        knapsack2(weight, value, bagSize);
//        knapsack33(weight, value, bagSize);
//        CompleteKnapsack(weight, value, bagSize);
//        CompleteKnapsack1(weight, value, bagSize);
        CompleteKnapsack2(weight, value, bagSize);
    }

    // 完全背包
    public static void CompleteKnapsack(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < bagSize + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            for (int i1 : dp) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
        System.out.println("背包所获得的最大价值为：" + dp[bagSize]);
    }

    // 完全背包 从0-1背包过来的
    public static void CompleteKnapsack1(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                for (int k = 0; k < j / weight[i] + 1; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
            for (int i1 : dp) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
        System.out.println("背包所获得的最大价值为：" + dp[bagSize]);
    }

    // 完全背包 二重dp
    public static void CompleteKnapsack2(int[] weight, int[] value, int bagSize) {
        // 定义dp数组
        int[][] dp = new int[weight.length + 1][bagSize + 1];
        // 先遍历物品，再遍历背包容量
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                // 装不下当前物品
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {  // 能装下，选择装与不装，取价值最大的。
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        // 打印dp数组
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("背包所获得的最大价值为：" + dp[weight.length][bagSize]);
    }

    public static void knapsack2(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = bagSize; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
            /*for (int jj : dp) {
                System.out.print(jj + " ");
            }
            System.out.println();*/
        }
        System.out.println("背包所获得的最大价值为：" + dp[bagSize]);
    }

    public static void knapsack33(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            for (int jj : dp) {
                System.out.print(jj + " ");
            }
            System.out.println();
        }
        System.out.println("背包所获得的最大价值为：" + dp[bagSize]);
    }

    public static void knapsack(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length + 1][bagSize + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        // 打印dp数组
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("背包所获得的最大价值为：" + dp[weight.length][bagSize]);
    }

    public static void knapsack1(int[] weight, int[] value, int bagSize) {

        int[][] dp = new int[weight.length][bagSize + 1];
        for (int j = weight[0]; j < bagSize + 1; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("背包所获得的最大价值为：" + dp[weight.length - 1][bagSize]);
    }



    public static void fun11() {
        boolean[] visited = {true, true, true};
        System.out.println(visited[1]);
        fnums(visited);
        System.out.println(visited[1]);
        System.out.println(visited[0]);

        char[] temp = {'1', '2', '3'};
//        System.out.println(Arrays.toString(temp));  // [1, 2, 3]
//        System.out.println(Arrays.toString(temp).length());  // 长度为 9
        String S = new String(temp);
        System.out.println(S);

        String ss = "abc";
        System.out.println('.' + ss);
    }

    public static void fnums(boolean[] visited) {
        visited[1] = false;
    }

    public static void f() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(4);
        deque.add(6);
        deque.addFirst(8);
        deque.addFirst(7);
        deque.addLast(10);
        deque.add(6);
        deque.offer(11);
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(deque.peek());  // 7

        System.out.println("---------------");
        System.out.println(Collections.max(deque));
        System.out.println("---------------");

        deque.offer(11);
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();

        TreeNode root = TreeNode.deserialize("5,4,6,1,2,7,8");
        TreeNode.preorderTraversal(root);
        TreeNode.inorderTraversal(root);
        TreeNode.postorderTraversal(root);

        System.out.println("============");
        System.out.println(func(5));

        System.out.println("===========swap================");
        int a = 2, b = 3;
        myswap(a, b);
        System.out.println(a + " " + b);  // 2 3

        int[] arr = {1, 2, 3, 4};
        myarrswap(arr);
        System.out.println(Arrays.toString(arr));  // [2, 1, 3, 4]

        System.out.println("===========funcMath================");
        funcMath();
    }

    public static int func(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
//        int res = 1;
//        for (int i = 1; i <= n; ++i) {
//            res *= i;
//        }
        return n * func(n - 1);
    }

    public static void myswap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void myarrswap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static void funcMath() {
        System.out.println(Math.max(1, 4));
        System.out.println(Math.PI - Math.PI);
    }
}
