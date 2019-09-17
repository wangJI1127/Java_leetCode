package 牛客.心动网络;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/29
 * @Modifited By:
 */

import java.util.Scanner;

/**
 * @ClassName:diyi
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/29 19:44
 * @Version:1.0
 **/
public class diyi {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String dict = in.nextLine().trim();
        int nums = in.nextInt();
        String[] list = new String[nums];
        int ii = 0;
        while (in.hasNext()) {

            if (ii == nums) {
                break;
            }
            list[ii] = in.next().trim();
            ii++;
        }

        for (int i=nums-1; i>=0; i--){
            for (int j=0; j<i; j++){
                int daxiao = comp(list[j], list[j+1], dict);
                if (daxiao == -1) {
                    String temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

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
