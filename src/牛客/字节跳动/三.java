package 牛客.字节跳动;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/15
 * @Modifited By:
 */

import java.util.Scanner;

/**
 * @ClassName:三
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/15 15:50
 * @Version:1.0
 **/
public class 三 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int l = 0;
        int r = n-1;
        int times = 1;
        int res = 0;
        while (l <= r){
            int temp;
            if (arr[l] > arr[r]){
                temp = arr[l];
                l++;
            }else {
                temp = arr[r];
                r--;
            }
            if (times % 2 == 1) {
                res += temp;
            }
            times++;
        }
        System.out.println(res);
    }
}
