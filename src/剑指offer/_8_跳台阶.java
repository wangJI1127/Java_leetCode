package 剑指offer;
/**
 * @Author: 王吉
 * @Description：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

/**
 * @ClassName:_8_跳台阶
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 16:15
 * @Version:1.0
 **/
public class _8_跳台阶 {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
