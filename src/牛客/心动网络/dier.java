package 牛客.心动网络;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/29
 * @Modifited By:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:dier
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/29 20:39
 * @Version:1.0
 **/
public class dier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] jieArr = new int[num];
        for (int i=0; i<num; i++){
            jieArr[i] = in.nextInt();
        }
        int[][] bianArr = new int[num-1][2];
        for (int i=0; i<num-1; i++){
            bianArr[i][0] = in.nextInt();
            bianArr[i][1] = in.nextInt();
        }
        if (num == 1) {
            System.out.println(0);
        }
        if (num == 2){
            System.out.println(jieArr[1]);
        }
        int curr = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i=0; i<num-1; i++){
            if (bianArr[i][0] == curr || bianArr[i][1] == curr){
                left.add(i);
                if (bianArr[i][1] == curr){
                    curr = bianArr[i][0];
                }else{
                    curr = bianArr[i][1];
                }
            }
        }
        for (int i=1; i<num; i++){
            if (!left.contains(i)) {
                right.add(i);
            }
        }
        int l = 0;
        int r = 0;
        for (Integer integer : left) {
            l += jieArr[integer];
        }
        for (Integer integer : right) {
            r += jieArr[integer];
        }
        System.out.println(Math.abs(l -r));
    }
}
