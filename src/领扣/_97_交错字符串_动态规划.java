package 领扣;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _97_交错字符串_动态规划 {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())){
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        Boolean [][] dp = new Boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i=1; i<=n; i++){
            dp[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }

        for (int i=1; i<=m; i++){
            dp[0][i] = s2.substring(0,i).equals(s3.substring(0, i));
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "aabcc";
        String str2 = "dbbca";
        String str3 = "aadbbcbcac";
        boolean res = isInterleave(str1, str2, str3);
        System.out.println(str1.substring(0,2).equals(str3.substring(0,2)));
    }
}
