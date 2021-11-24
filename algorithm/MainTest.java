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


    }
}
