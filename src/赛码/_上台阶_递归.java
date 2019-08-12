package 赛码;

import java.util.Scanner;

/**
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？
 *
 * 注：规定从一级到一级有0种走法。
 *
 *
 *
 *
 * 输入
 *
 * 输入数据首先包含一个整数n(1<=n<=100)，表示测试实例的个数，然后是n行数据，每行包含一个整数m，（1<=m<=40), 表示楼梯的级数。
 *
 *
 * 样例输入
 *
 * 2
 *
 * 2
 *
 * 3
 *
 * 输出
 *
 * 对于每个测试实例，请输出不同走法的数量。
 *
 *
 * 样例输出
 *
 * 1
 *
 * 2
 */
public class _上台阶_递归 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0){
            int num = in.nextInt();
            System.out.println(helper(num-1));
        }
    }

    private static int helper(int n){
        // 递归
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return helper(n-1) + helper(n-2);
    }
}
