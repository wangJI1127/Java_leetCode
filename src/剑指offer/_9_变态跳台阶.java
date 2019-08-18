package 剑指offer;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

import java.util.Arrays;

/**
 * @ClassName:_9_变态跳台阶
 * @Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Author:ASUS
 * @Date:2019/8/18 16:17
 * @Version:1.0
 **/
public class _9_变态跳台阶 {
    public int JumpFloorII(int target) {
        int[] arr = new int[target];
        Arrays.fill(arr,1);
        for (int i=1; i<target; i++){
            for (int j=0; j<i; j++){
                arr[i] += arr[j];
            }
        }
        return arr[target-1];
    }
}
