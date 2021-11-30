import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import datastructure.TreeNode;

/**
 * @author Axehco
 * @createTime 2021年11月23日 9:25
 */
public class MainTest {
    public static void main(String[] args) {
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
