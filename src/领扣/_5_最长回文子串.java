package 领扣;
/**
* @author ASUS
* @Description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @Date 12:32 2019/8/17
* @Param
* @return
**/

/**
* @author ASUS
* @Description
* @Date 12:32 2019/8/17
* @Param
* @return
**/
public class _5_最长回文子串 {
    public static String longestPalindrome(String s) {
        if (s .equals("") ){
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)){
                return s;
            }else {
                return s.substring(0,1);
            }
        }
        int max = 0;
        int left = 0;
        int right = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++){
            dp[i][i] = true;
            if (i + 1 < s.length()) {
                dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
                if (dp[i][i+1]){
                    max = 1;
                    left = i;
                    right = i+2;
                }
            }
        }
        for (int i=s.length()-3; i>=0; i--){
            for (int j=s.length()-1; j>i+1; j--){
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j]){
                        if (max < j - i){
                            max = j - i;
                            left = i;
                            right = j+1;
                        }
                    }
            }
        }
        return s.substring(left,right);
    }

    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(longestPalindrome(s));
    }
}
