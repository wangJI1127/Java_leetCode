package 基础算法;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/10
 * @Modifited By:
 */

/**
 * @ClassName:链表翻转
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/10 16:25
 * @Version:1.0
 **/
public class 链表翻转 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public ListNode reverseList(ListNode head) {
        // 迭代
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        // 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
