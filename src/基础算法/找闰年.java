package 基础算法;

public class 找闰年 {
    private static void findLeapYear(int start, int end){
        for (int i=start; i<=end; i++){
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        findLeapYear(1900, 2020);
    }
}
