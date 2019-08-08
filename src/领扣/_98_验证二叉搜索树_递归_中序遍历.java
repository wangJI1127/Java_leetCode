package 领扣;

import java.util.ArrayList;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _98_验证二叉搜索树_递归_中序遍历 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer up, Integer down){
        if (root == null){
            return true;
        }
        if (down != null && root.val <= down) {
            return false;
        }
        if (up != null && root.val >= up) {
            return false;
        }
        if (!helper(root.left, root.val, down)){
            return false;
        }
        if (!helper(root.right, up, root.val)){
            return false;
        }
        return true;
    }


    public boolean isValidBST1(TreeNode root){
        //中序遍历
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> list){
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public boolean isValidBST2(TreeNode root){
        // 深度优先搜索
        return true;
    }


}
