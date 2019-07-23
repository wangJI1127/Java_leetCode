/**
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 解法讲解：https://www.cnblogs.com/TenosDoIt/p/3738693.html
 */
public class _6_zigzag_conversion {
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int k = 0;
        int interval = (numRows<<1)-2;
        int len = s.length();
        char[] s_array = s.toCharArray();
        char[] s_new = new char[len];
        for(int i=0;i<len;){
            s_new[k] = s_array[i];
            k++;
            i += interval;
        }
        for(int j=1;j<numRows-1;j++){
            int inter = j<<1;
            for(int i=j;i<len;i += inter){
                s_new[k++] = s_array[i];
                inter = interval - inter;
            }
        }
        for(int i=numRows-1;i<len;i += interval){
            s_new[k++] = s_array[i];
        }
        return String.copyValueOf(s_new);
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
//        String ss = convert(s, 3);
        System.out.println(s.toCharArray());
    }
}
