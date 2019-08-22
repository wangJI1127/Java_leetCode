package 领扣;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = target;
        for (int i=0; i<nums.length-2; i++){
            if (nums[i] - target > min){
                break;
            }
            int l = i + 1;
            int r = nums.length-1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                }else if (sum > target){
                    r--;
                    if (Math.abs(sum-target) < min){
                        min = Math.abs(sum-target);
                        res = sum;
                    }
                }else {
                    l++;
                    if (Math.abs(sum-target) < min){
                        min = Math.abs(sum-target);
                        res = sum;
                    }
                }
            }
        }
        return res;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = target;
        for (int i=0; i<nums.length-2; i++){
            if (nums[i] - target > min){
                break;
            }
            int l = i + 1;
            int r = nums.length-1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(sum - target);
                if (diff == 0) {
                    return target;
                }
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if (sum > target) {
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
