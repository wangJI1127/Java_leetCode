package 牛客.完美世界;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/23
 * @Modifited By:
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName:dier
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/23 19:46
 * @Version:1.0
 **/
public class dier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [][] shuru = new int[6][6];
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                shuru[i][j] = in.nextInt();
            }
        }
        int[] dp = new int[6];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i=0; i<6; i++) {
            for (int j = 0; j < 6; j++) {
                if (shuru[i][j] == -1) {
                    continue;
                }else {
                    if (dp[j] == -1) {
                        dp[j] = shuru[i][j];
                    }else {
                        dp[j] = Math.min(dp[j], shuru[i][j] + dp[i]);
                    }
                }
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }
    }
}
