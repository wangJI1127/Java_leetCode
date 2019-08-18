package 剑指offer;
/**
 * @Author: 王吉
 * @Description：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 *          则经过替换之后的字符串为We%20Are%20Happy。
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

/**
 * @ClassName:_2_替换空格
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 15:26
 * @Version:1.0
 **/
public class _2_替换空格 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
