/**
 *Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class _5_longest_palindromic_substring {

    public static String longestPalindrome(String s) {
        if ("".equals(s)){
            return "";
        }
        char [] s_array = s.toCharArray();
        char [] s_new = new char[s_array.length * 2 + 1];
        for(int i=0;i<s_array.length;i++){
            s_new[i * 2] = '#';
            s_new[i * 2 + 1] = s_array[i];
        }
        s_new[s_new.length-1] = '#';
        int maxPoint = 0;
        int max = 0;
        int [] s_count = new int[s_array.length * 2 + 1];
        for(int i=0;i<s_new.length;i++){
            int count = 1;
            int l = i - 1;
            int r = i + 1;
            while (l>=0 && r<s_new.length && s_new[l] == s_new[r]){
                count++;
                l--;
                r++;
            }
            s_count[i] = count;
            maxPoint = count > max ? i : maxPoint;
            max = count > max ? count : max;

        }
        if(maxPoint % 2 == 0){
            return s.substring(maxPoint / 2 - (max - 1) / 2, maxPoint / 2 + (max - 1) / 2);
        }else {
            return s.substring((int)(maxPoint / 2) - (max - 2) / 2, (int)(maxPoint / 2) + (max - 2) / 2 + 1);
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        String ss = longestPalindrome(s);
        System.out.println(ss);
    }
}
