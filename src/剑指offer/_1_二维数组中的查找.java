package 剑指offer;
/**
 * @Author: 王吉
 * @Description：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的
 *              顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

/**
 * @ClassName:_1_二维数组中的查找
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 10:51
 * @Version:1.0
 **/
public class _1_二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int col = array[0].length;
        if (row < 0 && col < 0) {
            return false;
        }
        // 从右上角开始
        int i = 0;
        int j = col-1;
        while (i < row && j >= 0){
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
