package lintCode;

/**
 *给定一个二叉树，判断其是否是一个有效的二叉搜索树。
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


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



public class _98_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        // 递归法
        return heaper(root, null, null);
    }

    private boolean heaper(TreeNode root, Integer lower, Integer upper){
        if (root==null){
            return true;
        }
        if (lower!=null && root.val <= lower){
            return false;
        }
        if (upper!=null && root.val >= upper){
            return false;
        }

        if (!heaper(root.left,lower, root.val)){
            return false;
        }
        if (!heaper(root.right, root.val, upper)){
            return false;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root){
        //递归法  使用深度优先遍历
        return true;
    };

    public boolean isValidBST2(TreeNode root){
        // 中序遍历
        return true;
    };






    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
