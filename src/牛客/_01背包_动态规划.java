package 牛客;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/708f0442863a46279cce582c4f508658
 * 来源：牛客网
 *
 * 现有一个容量大小为V的背包和N件物品，每件物品有两个属性，体积和价值，请问这个背包最多能装价值为多少的物品？
 *
 * 输入描述:
 *
 * 第一行两个整数V和n。
 * 接下来n行，每行两个整数体积和价值。1≤N≤1000,1≤V≤20000。
 * 每件物品的体积和价值范围在[1,500]。
 *
 *
 *
 * 输出描述:
 *
 * 输出背包最多能装的物品价值。
 *
 * 示例1
 * 输入
 *
 * 6 3
 * 3 5
 * 2 4
 * 4 2
 *
 * 输出
 *
 * 9
 */

public class _01背包_动态规划 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = n;
        while (i-- > 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (in.hasNext()) {
                arrayList.add(in.nextInt());
                if (arrayList.size() == 2) {
                    break;
                }
            }
            list.add(arrayList);
        }
        int res = helper1(list, v, n);
        System.out.println(res);

    }

    private static int helper(ArrayList<ArrayList<Integer>> lists, int v, int n){
        // 动态规划, 二维数组
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

    private static int helper1(ArrayList<ArrayList<Integer>> lists, int v, int n){
        // 动态规划, 一维数组
        int[] dp = new int[v+1];

        for (int i=0; i<n; i++){
            for (int j = 0; j<=v; j++){
                if (lists.get(i).get(0) > j) {
                    // 放不下
                    if (i == 0) {
                        dp[j] = 0;
                    }else {
                        dp[j] = dp[j];
                    }

                }else {
                    //放的下
                    if (i == 0) {
                        dp[j] = lists.get(i).get(1);
                    }else {
                        dp[j] = Math.max(dp[j], dp[j-lists.get(i).get(0)]+lists.get(i).get(1));
                    }
                }
            }
        }
        return dp[v];
    }
}
