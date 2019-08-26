package 领扣;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 *
 *
 * 提示：
 *
 *     你必须返回给定头的拷贝作为对克隆列表的引用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _138_复制带随机指针的链表 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node clone = new Node(head.val, null, null);
        Map<Node, Node> map = new HashMap<>();
        map.put(head, clone);
        map.put(null, null);
        Node curr = head;
        while (curr != null) {
            if (curr.next != null && !map.containsKey(curr.next)) {
                map.put(curr.next, new Node(curr.next.val, null, null));
            }
            map.get(curr).next = map.get(curr.next);
            if (curr.random != null && !map.containsKey(curr.random)) {
                map.put(curr.random, new Node(curr.random.val, null, null));
            }
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return clone;
    }
}
