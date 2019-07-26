package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _144_Binary_Tree_Preorder_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归简单
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }


    public List<Integer> preorderTraversal1(TreeNode root) {
        // 迭代
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
