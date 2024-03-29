package 领扣;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
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
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _105_从前序与中序遍历序列构造二叉树_递归 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        // 递归
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = findIndex(inorder, preorder[preStart]);
        root.left = helper(preorder, inorder, preStart+1, preStart-inStart+index, inStart, index-1);
        root.right = helper(preorder, inorder, preStart-inStart+index+1, preEnd, index+1, inEnd);
        return root;
    }

    private int findIndex(int[] arr, int key){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
