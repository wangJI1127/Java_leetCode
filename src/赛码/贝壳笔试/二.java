package 赛码.贝壳笔试;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/10
 * @Modifited By:
 */

import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName:二
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/10 19:05
 * @Version:1.0
 **/
public class 二 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (in.hasNext()) {
            arr[i++] = in.nextInt();
            if (i == n){
                break;
            }
        }
        System.out.println(helper(arr));
    }

    private static int helper(int[] arr){
        int [] dp = new int[arr.length];
        dp[0] = 1;
        for (int i=1; i<arr.length; i++){
            int max = dp[i-1];
            for (int j=0; j<i; j++){
                if (arr[j] < arr[i]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
        }
        return dp[arr.length-1];
    }
}
