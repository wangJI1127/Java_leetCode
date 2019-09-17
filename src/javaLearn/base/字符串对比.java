package javaLearn.base;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/14
 * @Modifited By:
 */

import org.omg.Messaging.SyncScopeHelper;

/**
 * @ClassName:字符串对比
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/14 14:19
 * @Version:1.0
 **/
public class 字符串对比 {
    public static void main(String[] args) {
        String s1 = "王";
        String s2 = "吉";
        String s3 = "王吉"; // 字符串常量池
        String s4 = s1 + s2; // 在堆上创建新对象
        String s5 = new String("王吉"); // 在堆上创建新对象
        String s6 = s3.intern(); // 字符串常量池
        String s7 = s4.intern(); // 字符串常量池
        String s8 = s5.intern(); // 字符串常量池
        String s9 = "王" + "吉"; // 字符串常量池
        System.out.println(s3 == s4);  // false
        System.out.println(s3 == s5);  // false
        System.out.println(s3 == s6); // true
        System.out.println(s3 == s7); // true
        System.out.println(s3 == s8); // true
        System.out.println(s4 == s5); // false
        System.out.println(s4 == s6);  // false
        System.out.println(s4 == s7);  // false
        System.out.println(s4 == s8);  // false
        System.out.println(s5 == s6);  // false
        System.out.println(s5 == s7);  // false
        System.out.println(s6 == s7); // true
        System.out.println(s6 == s8); // true
        System.out.println(s9 == s3); // true
        System.out.println(s9 == s4);  // false
        System.out.println(s9 == s5);  // false
        System.out.println(s9 == s6); // true
        System.out.println(s9 == s7); // true
        System.out.println(s9 == s8); // true

    }
}
