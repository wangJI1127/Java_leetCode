package 剑指offer;
/**
 * @Author: 王吉
 * @Description：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Date: Created in  2019/8/18
 * @Modifited By:
 */

/**
 * @ClassName:_4_重建二叉树
 * @Description:
 * @Author:ASUS
 * @Date:2019/8/18 15:44
 * @Version:1.0
 **/

public class _4_重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return help(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    private TreeNode help(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode head = new TreeNode(pre[preStart]);
        int index = findIndex(in, pre[preStart]);
        head.left = help(pre, in, preStart+1, preStart+index-inStart, inStart, index-1);
        head.right = help(pre, in, preStart+index-inStart+1, preEnd, index+1, inEnd);
        return head;
    }

    private int findIndex(int[] array, int key){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

}
