package 领扣;

/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *
 *
 * 提示：
 *
 *     给定树中的结点数介于 1 和 100 之间。
 *     每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _897_递增顺序查找树_中序遍历_构造新的树 {
      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }

      public TreeNode increasingBST(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            interOrder(root, list);
            TreeNode head = new TreeNode(list.get(list.size()-1));
            for (int i=list.size()-2; i>=0; i--){
                TreeNode node = new TreeNode(list.get(i));
                node.right = head;
                head = node;
            }
            return head;
      }

      private void interOrder(TreeNode root, ArrayList<Integer> list){
          if (root == null) {
              return;
          }
          interOrder(root.left, list);
          list.add(root.val);
          interOrder(root.right, list);
      }
}
