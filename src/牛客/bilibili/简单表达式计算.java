package 牛客.bilibili;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *

 给定一个合法的表达式字符串，其中只包含非负整数、加法、减法以及乘法符号（不会有括号），例如7+3*4*5+2+4-3-1，请写程序计算该表达式的结果并输出；

 输入描述:

 输入有多行，每行是一个表达式，输入以END作为结束


 输出描述:

 每行表达式的计算结果


 输入例子1:

 7+3*4*5+2+4-3-1
 2-3*1
 END


 输出例子1:

 69
 -1


 */
public class 简单表达式计算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.next().trim();
            if (s.equals("END")) {
                break;
            }
            System.out.println(calculate(s));
        }
    }

    private static int calculate(String s){
        ArrayList<Integer> stringNum = new ArrayList<>();
        ArrayList<Character> stringOp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                StringBuffer stringBuffer=new StringBuffer();
                while (i < s.length()&&s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    stringBuffer.append(s.charAt(i));
                    i++;
                }
                i--;
                stringNum.add(Integer.parseInt(String.valueOf(stringBuffer)));
            }else{
                stringOp.add(s.charAt(i));
            }
        }
        for (int i = 0; i < stringOp.size(); i++) {
            if (stringOp.get(i)=='*'){
                int tmp=stringNum.get(i)*stringNum.get(i+1);
                stringNum.set(i,tmp);
                stringNum.remove(i+1);
                stringOp.remove(i--);
            }
        }
        for (int i = 0; i < stringOp.size(); i++) {
            if (stringOp.get(i)=='+'){
                int tmp=stringNum.get(i)+stringNum.get(i+1);
                stringNum.set(i,tmp);
                stringNum.remove(i+1);
                stringOp.remove(i--);
            }else {
                int tmp=stringNum.get(i)-stringNum.get(i+1);
                stringNum.set(i,tmp);
                stringNum.remove(i+1);
                stringOp.remove(i--);
            }
        }
        return stringNum.get(0);
    }
}
