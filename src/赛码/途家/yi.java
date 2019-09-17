package 赛码.途家;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/6
 * @Modifited By:
 */

import java.util.Scanner;

/**
 * @ClassName:yi
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/6 19:56
 * @Version:1.0
 **/
public class yi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fali = in.nextInt();
        int dis = in.nextInt();
        int time = in.nextInt();
        int dis_chi = dis;
        int time_chi = time;
        int res = 0;
        int chushi = fali / 10;
        fali = fali % 10;
        dis -= 50 * chushi;
        time -= chushi;
        while (time > 0 && dis > 0) {
            int temp_huafei = 0;
            int temp_fali = 0;
            while (fali+temp_fali < 10) {
                temp_fali += 4;
                temp_huafei++;
            }
            if ((temp_huafei * 13 < 50 && time >= 7)){
                fali = fali + temp_fali -10;
                dis -= 50;
                time -= (temp_huafei+1);
            }else {
                while (time > 0 && dis > 0) {
                    dis -= 13;
                    time--;
                }
            }
        }
        if (time >= 0) {
            System.out.println("Yes");
            System.out.println(time_chi-time);
        }
        if (dis > 0) {
            System.out.println("No");
            System.out.println(dis_chi-dis);
        }
    }
}
