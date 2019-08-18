package 牛客.作业帮;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/14
 * @Modifited By:
 */

import java.util.Arrays;

/**
 * @ClassName:一
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/14 20:16
 * @Version:1.0
 **/
public class 一 {
    public static void main(String[] args) {
        String str = "sadasf";
        char[] arr = str.toCharArray();
        char[] arr_r = new char[arr.length];
        for (int i=arr.length-1; i>=0; i--){
            arr_r[arr.length-1-i] = arr[i];
        }
        String res = new String(arr_r);
        System.out.println(res);
    }
}
