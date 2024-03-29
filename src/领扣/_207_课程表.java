package 领扣;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 说明:
 *
 *     输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 *     你可以假定输入的先决条件中没有重复的边。
 *
 * 提示:
 *
 *     这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 *     通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 *
 *     拓扑排序也可以通过 BFS 完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _207_课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 广度优先遍历  拓扑排序
        if (numCourses <= 0) {
            return false;
        }
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 记录节点入度的权重
        for (int i = 0; i < degrees.length; i++) {
            // 先找到入度为0的节点进行入队
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // 拓扑排序, 去掉一个节点, 总结点数减一
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] != curr) {
                    continue;
                }
                // 遍历所有的边,找出入度为0的节点进行入队
                if (--degrees[prerequisite[0]] == 0) {
                    queue.offer(prerequisite[0]);
                }
            }
        }
        // 拓扑排序中,去掉所有的节点,说明没有环
        return numCourses == 0;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 深度优先遍历
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adjacency[prerequisite[1]][prerequisite[0]] = 1;
        }
        // 从每一个点出发,进行判断是否有环, 如果有一次有环,则返回false
        for (int i=0; i<numCourses; i++){
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] adjacency, int[] flags, int i){
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (int j=0; j<adjacency.length; j++){
            if (adjacency[i][j] == 1 && !dfs(adjacency, flags, j)){
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
