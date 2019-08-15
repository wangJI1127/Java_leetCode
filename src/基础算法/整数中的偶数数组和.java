package 基础算法;

/**
 * 注意要使用long类型
 */
public class 整数中的偶数数组和 {
    private static int intSum(Long num){
        Long temp = num;
        int chushu = 10;
        int sum = 0;
        while (temp > 0){
            Long i = temp % chushu;
            if (i % 2 == 0) {
                sum += i;
            }
            temp = (temp - i) / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(intSum(124242121421l));
    }
}
