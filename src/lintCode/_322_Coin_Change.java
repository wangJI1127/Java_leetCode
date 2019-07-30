package lintCode;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int amount, int[] count){
        // 动态规划，自上而下
        if (amount < 0) {
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, amount-coin,count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[amount-1] = (min == Integer.MAX_VALUE)?-1:min;
        return count[amount-1];
    }

    public int coinChange1(int[] coins, int amount) {
        // 动态规划， 自下而上
        int [] arr = new int[amount+1];
        arr[0] = 0;
        for (int i=1; i<=amount; i++){
            int min = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++){
                if (i - coins[j] >= 0){
                    if (arr[i - coins[j]] != Integer.MAX_VALUE) {
                        min = Math.min(min, arr[i - coins[j]]+1);
                    }
                }
            }
            arr[i] = min;
        }
        return arr[amount]==Integer.MAX_VALUE?-1:arr[amount];
    }
}
