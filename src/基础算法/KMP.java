package 基础算法;

public class KMP {

    private static int kmp1(String str1, String str2){
        // 暴力破解法
        int len1 = str1.length();
        int len2 = str2.length();
        int i=0;
        int j=0;
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else {
                j = 0;
                i = i - j + 1;
            }
        }
        if (j == len2) {
            return i - j;
        }else {
            return -1;
        }
    }

    private static int kmp2(String str1, String str2){
        // next 子数组
        int[] next = getNext(str2);
        int len1 = str1.length();
        int len2 = str2.length();
        int i=0;
        int j=0;
        while (i < len1 && j < len2) {
            if (j == -1 || str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j == len2) {
            return i - j;
        }else {
            return -1;
        }
    }

    private static int[] getNext(String string){
        int[] next = new int[string.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < string.length()-1){
            if (k == -1 || string.charAt(k) == string.charAt(j)){
                k++;
                j++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "abacababc";
        String str2 = "abab";
        System.out.println(kmp2(str1, str2));
    }
}
