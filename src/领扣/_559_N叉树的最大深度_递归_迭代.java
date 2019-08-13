package 领扣;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 *     树的深度不会超过 1000。
 *     树的节点总不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class _559_N叉树的最大深度_递归_迭代 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int maxDepth(Node root) {
        // 递归
        if (root == null){
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            max = Math.max(max, depth);
        }
        return max + 1;
    }

    private int maxDepth1(Node root){
        // 迭代 ，需要层次遍历
        if (root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count-- > 0){
                Node currNode = queue.poll();
                for (Node child : currNode.children) {
                    queue.add(child);
                }
            }
            depth++;
        }
        return depth;
    }
}
