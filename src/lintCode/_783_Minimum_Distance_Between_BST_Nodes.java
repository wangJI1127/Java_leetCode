package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 注意：
 *
 *     二叉树的大小范围在 2 到 100。
 *     二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _783_Minimum_Distance_Between_BST_Nodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static int temp2 = -100;
    static int temp1 = -100;
    static int min = 100;
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        Integer minNum = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            minNum = Math.min(minNum, list.get(i+1)-list.get(i));
        }
        return minNum;
    }

    private void helper(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

}
