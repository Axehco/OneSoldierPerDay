package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class sortColorsSolution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // 双指针
    // 注意交换的过程，有可能存在一个位置进行多次交换，并且判断顺序也很重要。
    /*public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, temp;
        for (int i = 0; i < nums.length; i++) {
            // 这里容易错，找到2要不断的与nums[right]进行交换
            while (i < right && nums[i] == 2) {
                temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }
            if (nums[i] == 0) {
                temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }*/

    /*// 双指针
    public void sortColors(int[] nums) {
        int ptr0 = 0, ptr1 = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp = nums[ptr1];
                nums[ptr1] = nums[i];
                nums[i] = temp;
                ptr1++;
            } else if (nums[i] == 0) {
                temp = nums[ptr0];
                nums[ptr0] = nums[i];
                nums[i] = temp;
                // 此时有可能把1也交换出去，就需要判断是否满足 ptr0 < ptr1，再将nums[i]与nums[ptr1]交换即可
                if (ptr0 < ptr1) {  // 这里是精髓
                    temp = nums[ptr1];
                    nums[ptr1] = nums[i];
                    nums[i] = temp;
                }
                // 因为0在最前面，因此要将其都要向后移动一个位置
                ptr0++;
                ptr1++;
            }
        }
    }*/

    // 单指针，进行两次交换即可实现 好理解！
    /*public void sortColors(int[] nums) {
        int index = 0;
        // 把所有的0放在左边部分
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        // 再把所有的1放在0的右边部分
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }*/

    public static void main(String[] args) {
        sortColorsSolution solution = new sortColorsSolution();
        solution.sortColors(new int[]{2,0,2,1,1,0});
        solution.sortColors(new int[]{2,0,1});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
