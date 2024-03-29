package lintCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _95_Unique_Binary_Search_Trees_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate_tree(1, n);
    }

    private List<TreeNode> generate_tree(int start, int end){
        List<TreeNode> all_tree = new LinkedList<>();
        if (start > end) {
            all_tree.add(null);
            return all_tree;
        }

        for (int i=start; i<=end; i++){
            List<TreeNode> left_tree = generate_tree(start, i-1);
            List<TreeNode> right_tree = generate_tree(i+1, end);
            for (TreeNode l : left_tree) {
                for (TreeNode r : right_tree) {
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = l;
                    currNode.right = r;
                    all_tree.add(currNode);
                }
            }

        }
        return  all_tree;

    }
}
