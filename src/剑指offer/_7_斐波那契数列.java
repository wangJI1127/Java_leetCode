package 剑指offer;
/**
 * @Author: 王吉
 * @Description：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *  n<= 39
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

/**
 * @ClassName:_7_斐波那契数列
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 16:13
 * @Version:1.0
 **/
public class _7_斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0 ) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-2) + Fibonacci(n-1);
    }
}
