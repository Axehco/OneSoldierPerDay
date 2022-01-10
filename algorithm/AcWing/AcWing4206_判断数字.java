package AcWing;

import java.util.Scanner;

/**
 * @author Axehco
 * @createTime 2022年01月08日 21:45
 */
public class AcWing4206_判断数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) - '0') == 4 || (str.charAt(i) - '0') == 7) {
                sum++;
            }
        }
        System.out.println(sum == 4 || sum == 7 ? "YES" : "NO");
    }
}
