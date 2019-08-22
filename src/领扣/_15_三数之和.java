package 领扣;

import java.time.temporal.Temporal;
import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 背下来
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                List<Integer> temp = new ArrayList<>();
                if (nums[l] + nums[i] + nums[r] == 0){
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    while (l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[l] + nums[i] + nums[r] < 0){
                    l++;
                }else {
                    r--;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {1, 1, 1};
        threeSum(nums);
    }
}
