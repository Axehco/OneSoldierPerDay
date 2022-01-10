package AcWing;

import java.util.Scanner;

/**
 * @author Axehco
 * @createTime 2022年01月09日 16:49
 */
public class AcWing0785_快速排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < n; i++) {
            if (i != n - 1) System.out.print(nums[i] + " ");
            else System.out.print(nums[i]);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int mid = nums[(i + j) >> 1];
        while (i < j) {
            while (nums[i] < mid) i++;
            while (nums[j] > mid) j--;
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (left < i) quickSort(nums, left, j);
        if (right > i) quickSort(nums, i, right);
    }
}
