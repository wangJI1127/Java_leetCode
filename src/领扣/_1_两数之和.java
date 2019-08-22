package 领扣;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        // 复习1 暴力破解 时间复杂度O（n2）， 空间复杂度O（1）
        int [] res = new int[2];
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static int[] twoSum1(int[] nums, int target) {
        // 两遍哈希， 以空间换时间  时间复杂度O（n）, 空间复杂度O（n）。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++){
            int re = target - nums[i];
            if (map.containsKey(re)){
                if (map.get(re) != i){
                    return new int[]{i, map.get(re)};
                }
            }
        }
        throw new RuntimeException("cuowu");
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 一遍哈希， 在插入的之前， 判断是否有符合条件的数字 时间复杂度O（n）, 空间复杂度O（n）。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int re = target - nums[i];
            if (map.containsKey(re)){
                return new int[]{i, map.get(re)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException();
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
