package 牛客.心动网络;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/29
 * @Modifited By:
 */

/**
 * @ClassName:test
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/29 18:05
 * @Version:1.0
 **/
public class test {
    public static void main(String[] args) {
        String s = "eabcd";
        String s1 = "abd";
        String s2 = "efc";
        System.out.println(comp(s1, s2, s));
    }

    private static int comp(String str1, String str2, String dict){
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (dict.indexOf(str1.charAt(i)) == dict.indexOf(str2.charAt(j))) {
                i++;
                j++;
            }else if (dict.indexOf(str1.charAt(i)) > dict.indexOf(str2.charAt(j))){
                return -1;
            }else {
                return 1;
            }
        }
        if (i < len1){
            return -1;
        }
        if (j < len2) {
            return 1;
        }
        return 0;
    }
}
