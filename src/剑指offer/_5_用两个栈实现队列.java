package 剑指offer;
/**
 * @Author: 王吉
 * @Description：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

import java.util.Stack;

/**
 * @ClassName:_5_用两个栈实现队列
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 15:59
 * @Version:1.0
 **/
public class _5_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
