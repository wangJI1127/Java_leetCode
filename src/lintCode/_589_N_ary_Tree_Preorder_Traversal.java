package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class _589_N_ary_Tree_Preorder_Traversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        // 递归简单
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        for (Node child : root.children) {
            helper(child, list);
        }
    }

    public List<Integer> preorder1(Node root) {
        // 迭代
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i=node.children.size()-1; i>=0; i--){
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
