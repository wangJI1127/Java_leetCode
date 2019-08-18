package 剑指offer;
/**
 * @Author: 王吉
 * @Description：  输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

/**
 * @ClassName:_3_从尾到头打印链表
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 15:28
 * @Version:1.0
 **/

import java.util.ArrayList;
import java.util.List;

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */

public class _3_从尾到头打印链表 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(listNode, arrayList);
        return arrayList;
    }

    private static void helper(ListNode listNode, ArrayList<Integer> arrayList){
        if (listNode == null){
            return;
        }
        ListNode head = listNode.next;
        helper(head, arrayList);
        arrayList.add(listNode.val);
    }
}
