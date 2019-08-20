package 牛客.bilibili;

import java.util.Scanner;

/**
 * 22娘和33娘接到了小电视君的扭蛋任务：
 * 一共有两台扭蛋机，编号分别为扭蛋机2号和扭蛋机3号，22娘使用扭蛋机2号，33娘使用扭蛋机3号。
 * 扭蛋机都不需要投币，但有一项特殊能力：
 * 扭蛋机2号：如果塞x（x范围为>=0正整数）个扭蛋进去，然后就可以扭到2x+1个
 * 扭蛋机3号：如果塞x（x范围为>=0正整数）个扭蛋进去，然后就可以扭到2x+2个
 * 22娘和33娘手中没有扭蛋，需要你帮她们设计一个方案，两人“轮流扭”（谁先开始不限，扭到的蛋可以交给对方使用），用“最少”的次数，使她们能够最后恰好扭到N个交给小电视君。
 */
public class 扭蛋机 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tar = in.nextInt();
        find(tar, "", 0);
    }

    private static void find(int target, String res, int init){
        // 回溯  时间复杂度较大
        if (init > target){
            return;
        }
        if (init == target) {
            System.out.println(res);
        }else {
            find(target, res+3, init*2+2);
            res = res.substring(0, res.length());
            find(target, res+2, init*2+1);
            res = res.substring(0, res.length());
        }
    }

    private static String find(int target){
        StringBuilder res = new StringBuilder();
        while (target > 0){
            if (target % 2 == 0){
                res.append(3);
                target = (target - 2) / 2;
            }else {
                res.append(2);
                target = (target - 1) / 2;
            }
        }
        return res.reverse().toString();
    }
}
