package 领扣;

/**
 *在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 *
 *
 * 提示：
 *
 *     1 <= N <= 50
 *     0 <= grid[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _892_三维形体的表面积 {
    public int surfaceArea(int[][] grid) {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        int res = 0;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] != 0) {
                    res += 2;

                    for (int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        int na = 0;

                        if (nr>=0 && nr<grid.length && nc >=0 && nc <grid[0].length){
                            na = grid[nr][nc];
                        }
                        res += Math.max(grid[i][j]-na, 0);
                    }
                }
            }
        }
        return res;
    }
}
