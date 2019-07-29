package lintCode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _241_Different_Ways_to_Add_Parentheses {

    public List<Integer> diffWaysToCompute(String input) {
        return helper(input);
    }

    private List<Integer> helper(String input){
        List<Integer> list = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            list.add(Integer.valueOf(input));
            return list;
        }

        for (int i=0; i<input.length(); i++){
            if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i)=='*'){
                for (int l : helper(input.substring(0, i))){
                    for (int r : helper(input.substring(i+1))){
                        if (input.charAt(i) == '-'){
                            list.add(l - r);
                        }
                        if (input.charAt(i) == '+'){
                            list.add(l + r);
                        }
                        if (input.charAt(i) == '*'){
                            list.add(l * r);
                        }
                    }
                }
            }
        }
        return list;
    }
}
