package 基础算法;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/8
 * @Modifited By:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:约瑟夫环
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/8 16:34
 * @Version:1.0
 **/
public class 约瑟夫环 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入总人数：");
        int totalNum = scanner.nextInt();
        System.out.print("请输入报数的大小：");
        int cycleNum = scanner.nextInt();
        yuesefu(totalNum, cycleNum);
    }

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size()-1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
