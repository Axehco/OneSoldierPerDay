package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class canPlaceFlowersSolution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int[] copyFlowerbed = new int[flowerbed.length + 2];
        for (int i = 1; i < copyFlowerbed.length - 1; i++) {
            copyFlowerbed[i] = flowerbed[i -1];
        }
        for (int i = 1; i < copyFlowerbed.length - 1; i++) {
            if (copyFlowerbed[i - 1] == 0 && copyFlowerbed[i] == 0 && copyFlowerbed[i + 1] == 0) {
                cnt++;
                if (cnt >= n) return true;
                copyFlowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }

//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        if (flowerbed.length == 1 && flowerbed[0] == 0) return 1 >= n;
//        int ans = 0;
//        int cnt = 0;
//        boolean flag = false;
//        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 0) cnt++;
//            // 中间出现连续0的情况
//            if (flag && flowerbed[i] == 1) {
//                if (cnt >= 3) {
//                    ans += (cnt - 1) / 2;
//                }
//                cnt = 0;
//            }
//            // 还未出现1之前全部是0的情况
//            if (!flag && flowerbed[i] == 1) {
//                if (cnt % 2 == 1 && cnt > 2) ans += (cnt - 1) / 2;
//                else if (cnt % 2 == 0 && cnt >= 2)  ans += cnt / 2;
//                cnt = 0;
//                flag = true;
//            }
//        }
//        // flag == false 全是0的情况
//        // 否则末尾是0的情况
//        if (!flag) {
//            if (cnt % 2 == 1 && cnt > 2) ans += (cnt + 1) / 2;
//            else if (cnt % 2 == 0 && cnt >= 2)  ans += cnt / 2;
//        } else {
//            if (cnt % 2 == 1 && cnt > 2) ans += (cnt - 1) / 2;
//            else if (cnt % 2 == 0 && cnt >= 2)  ans += cnt / 2;
//        }
//        return ans >= n;
//    }

    public static void main(String[] args) {
        canPlaceFlowersSolution solution = new canPlaceFlowersSolution();
//        int[] flowerbed = {1,0,0,0,0,0,0,0,1};
//        int[] flowerbed = {0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0};
//        int[] flowerbed = {0,0,1,0,0};
        int[] flowerbed = {0,0,0,1,0,0,0,0,1,0,0};
        int n = 2;
        System.out.println(solution.canPlaceFlowers(flowerbed, n));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
