package 领扣;
/**
 * @Author: 王吉
 * @Description：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *  
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: Created in  2019/8/17
 * @Modifited By:
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName:_387_字符串中的第一个唯一字符
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/17 13:52
 * @Version:1.0
 **/
public class _387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i=0; i<s.length(); i++){
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
