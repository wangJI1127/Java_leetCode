package 牛客.字节跳动;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/15
 * @Modifited By:
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName:一
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/15 15:49
 * @Version:1.0
 **/
public class 一 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        Arrays.sort(arr);
        System.out.println(helper(arr, k));
    }

    private static int helper(int[] arr, int k){
        int res = 0;
        for (int i = 0; i<arr.length-2; i++){
            for (int j=i+1; j<arr.length-1; j++){
                for (int m = j+1; m<arr.length; m++){
                    if (arr[i] + arr[j] +arr[m] < k){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
