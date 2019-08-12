package 牛客;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/6ce78d70a25347058004691035d7540b
 * 来源：牛客网
 *
 * 有一个体积为V的背包，有m种物品，每种物品有体积和价值，且数量一定。求背包能装下的最大价值。
 *
 * 输入描述:
 *
 * 第一行两个整数V和m。
 * 接下来m行，每行3个整数，表示第i种物品的数量、体积和价值。
 * V≤104, m≤500V\leq10^4,\ m≤500V≤104, m≤500，个数、体积、价值不超过1000。
 *
 *
 *
 * 输出描述:
 *
 * 输出一个整数，表示背包能装下的最大价值。
 *
 * 示例1
 * 输入
 *
 * 10 4
 * 2 3 2
 * 2 4 3
 * 1 2 2
 * 4 5 3
 *
 * 输出
 *
 * 8
 */
public class _多重背包_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (m-- > 0) {
            int n = in.nextInt();
            int c = in.nextInt();
            int w = in.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(c);
            arrayList.add(w);
            while (n-- > 0) {
                list.add(arrayList);
            }
        }
        int res = helper(list, v, list.size());
        System.out.println(res);
    }

    private static int helper(ArrayList<ArrayList<Integer>> lists, int v, int n){
        // 直接转换为01背包问题会超时 通过80%
        int[][] dp = new int[n][v+1];

        for (int i=0; i<n; i++){
            for (int j = 0; j<=v; j++){
                if (lists.get(i).get(0) > j) {
                    // 放不下
                    if (i == 0) {
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }else {
                    //放的下
                    if (i == 0) {
                        dp[i][j] = lists.get(i).get(1);
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-lists.get(i).get(0)]+lists.get(i).get(1));
                    }
                }
            }
        }
        return dp[n-1][v];
    }
}
