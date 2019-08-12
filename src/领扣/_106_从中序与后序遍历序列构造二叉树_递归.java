package 领扣;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _106_从中序与后序遍历序列构造二叉树_递归 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public static TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend){
        // 递归
        if (instart > inend || postend < poststart) {
            return null;
        }
        int index = findIndex(inorder, postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = helper(inorder, postorder, instart, index-1, poststart,poststart+index-instart-1);
        root.right = helper(inorder, postorder, index+1, inend, poststart+index-instart, postend-1);
        return root;
    }

    private static int findIndex(int [] arr, int key){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        System.out.println(buildTree(inorder, postorder));
//        System.out.println(Arrays.binarySearch(inorder, 3));
    }

}
