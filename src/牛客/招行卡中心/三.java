package 牛客.招行卡中心;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/15
 * @Modifited By:
 */

import java.util.Scanner;

/**
 * @ClassName:三
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/15 21:32
 * @Version:1.0
 **/
public class 三 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        int min = Integer.parseInt(str.replace('?', '0'));
        int max = Integer.parseInt(str.replace('?', '9'));
        int res = 0;
        for (int i=min; i<=max; i++){
            if (i % 13 == 5){
                res++;
            }
        }
        System.out.println((int) res % (Math.pow(10, 9)+7));
    }
}
