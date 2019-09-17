package 牛客.酷家乐;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/8
 * @Modifited By:
 */

/**
 * @ClassName:test
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/8 14:44
 * @Version:1.0
 **/
public class test {

    public static int LastRemaining(int n,int m){
        if(n<1||m<1) {
            return -1;
        }
        int last = 2;
        for(int i=2;i<=n;i++) {
            last= (last+m)%i;
        }
        return last+1;
    }
    public static void main(String[] args) {
        int out = LastRemaining(2,1);
        System.out.println(out);
    }
}
