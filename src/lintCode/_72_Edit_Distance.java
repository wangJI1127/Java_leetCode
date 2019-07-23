package lintCode;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

/**
 *给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 *     插入一个字符
 *     删除一个字符
 *     替换一个字符
 *
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][] arr = new int[n+1][m+1];
        arr[0][0] = 0;
        for (int i = 1;i<=n;i++){
            arr[i][0] = i;
        }
        for (int j = 1;j<=m;j++){
            arr[0][j] = j;
        }
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){
                int leftup = arr[i-1][j-1];
                int left = arr[i][j-1];
                int up = arr[i-1][j];
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    leftup -= 1;
                }
                arr[i][j] = Math.min(Math.min(left, up), leftup) + 1;
            }
        }
        return arr[n][m];
    }
}
