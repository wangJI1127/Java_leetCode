package 领扣;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _653_两数之和IV_输入BST {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        int l = 0;
        int r = arr.size()-1;
        while (l < r) {
            int sum = arr.get(l) + arr.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            }else {
                l++;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> arr){
        if (root == null){
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
}
