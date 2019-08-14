package 基础算法;

/**
 * 判断一个数是否为素数
 */
public class 判断素数 {

    public static void main(String[] args) {
        for (int i=1; i<100; i++){
            if (isSushu4(i)) {
                System.out.println(i);
            }
        }
    }


    private static boolean isSushu1(int n){
        if (n <= 3){ // 小于等于三的数只有2,3为素数
            return n > 1;
        }
        // 最简单的方法, 循环对比每一个因子
        for (int i=2; i<n; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSushu2(int n){
        // 假如n是合数，必然存在非1的两个约数p1和p2，其中p1<=sqrt(n)，p2>=sqrt(n)。由此我们可以改进上述方法优化循环次数
        // 跟方法一相比，减少了for循环的次数
        if (n <= 3){
            return n > 1;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSushu3(int n){
        if (n <= 3) {
            return n > 1;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i=3; i*i<=n; i+=2){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSushu4(int n){
        // 质数还有一个特点，就是它总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数
        if (n <= 3) {
            return n > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
