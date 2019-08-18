package 牛客.作业帮;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/14
 * @Modifited By:
 */

import java.util.Scanner;

/**
 * @ClassName:二
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/14 19:44
 * @Version:1.0
 **/
public class 二 {
    /**
    * @author ASUS
    * @Description 设置两个指针，分别从数组的左右两边分别向中间移动，没移动一步都进行对比，当指针指向的两个数的和为目标值，则输出
     *     所以时间复杂度为O(n), n为数组的长度
    * @Date 20:03 2019/8/14
    **/
    public static void find(int[] nums, int tarfet){
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            if (nums[l] + nums[r] == tarfet){
                System.out.print(nums[l] + ",");
                System.out.println(nums[r]);
                l++;
                r--;
            }else if (nums[l] + nums[r] > tarfet){
                r--;
            }else {
                l++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.next();
        int target = sc.nextInt();
        strs = strs.substring(1, strs.length()-1);
        String[] nums_s = strs.split(",");
        int[] nums = new int[nums_s.length];
        for (int i = 0; i < nums_s.length; i++) {
            nums[i] = Integer.valueOf(nums_s[i]);
        }
        find(nums, target);
    }
}
