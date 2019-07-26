package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _94_Binary_Tree_Inorder_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归简单
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    public List<Integer> inorderTraversal1(TreeNode root){
        // 迭代   使用栈
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;

    }

}
