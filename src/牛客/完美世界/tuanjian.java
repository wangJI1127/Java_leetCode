package 牛客.完美世界;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/8/23
 * @Modifited By:
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @ClassName:tuanjian
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/23 18:57
 * @Version:1.0
 **/
public class tuanjian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (in.hasNext()) {
            arrayList.add(in.nextInt());
        }
        int k = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        Collections.sort(arrayList);
        int i = 0;
        int j = arrayList.size()-1;
        int num = 0;
        while (i < j) {
            if (arrayList.get(i) + arrayList.get(j) <= k) {
                i++;
                j--;
                num++;
            }else {
                j--;
                num++;
            }
        }
        if (i == j) {
            System.out.println(num+1);
        }else {
            System.out.println(num);
        }
    }


}
