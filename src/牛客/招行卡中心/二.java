package 牛客.招行卡中心;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/15
 * @Modifited By:
 */

import java.util.Scanner;

/**
 * @ClassName:二
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/15 21:11
 * @Version:1.0
 **/
public class 二 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] arrs = new long[n][n];
        while (in.hasNext()) {
            int r = in.nextInt();
            int c = in.nextInt();
            arrs[r-1][c-1] = in.nextLong();
        }

        long[] dp = new long[n];
        dp[n-1] = 0;
        for (int i=n-2; i>=0; i--){
            for (int j=0; j<n; j++){
                dp[i] = Math.max(dp[i], arrs[i][j] + dp[j]);
            }
        }
        for (long l : dp) {
            System.out.print(l + " ");
        }
    }
}
