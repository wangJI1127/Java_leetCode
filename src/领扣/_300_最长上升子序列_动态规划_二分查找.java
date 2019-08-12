package 领扣;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _300_最长上升子序列_动态规划_二分查找 {

    public static void main(String[] args) {
//        int [] nums = {1,3,6,7,9,4,10,5,6};
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS1(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        // 动态规划， 时间复杂度O（n2）
        if (nums.length == 0){
            return 0;
        }
        // dp[i]记录0到i-1位置有多少个数小于第i个数
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i=1; i<nums.length; i++){
            dp[i] = 1;
            for (int j=i-1; j>=0; j--){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int lengthOfLIS1(int[] nums) {
        // 动态规划+二分查找 ： O（nlogn）
        // dp记录当前的上升的子序列
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // Arrays.binarySearch(), 二分搜索，做查到怎返回index，
            // 若没有查询到，则返回   -第一个大于key的值的index， 使用返回值+1×（-1），就是该key应该插入的位置
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
