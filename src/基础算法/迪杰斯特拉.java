package 基础算法;

import java.util.Arrays;

public class 迪杰斯特拉 {

    class MatrixUDG{
        // 邻接矩阵
        private int mEdgNum;        // 边的数量
        private char[] mVexs;       // 顶点集合
        private int[][] mMatrix;    // 邻接矩阵
        private static final int INF = Integer.MAX_VALUE;   // 最大值
    }

    /*
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    private void dijkstra(int vs, int[] prev, int[] dist, MatrixUDG matrixUDG){
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[matrixUDG.mVexs.length];

        // 初始化
        for (int i = 0; i < matrixUDG.mVexs.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = matrixUDG.mMatrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k=0;
        for (int i = 1; i < matrixUDG.mVexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrixUDG.mVexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }

            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < matrixUDG.mVexs.length; j++) {
                int tmp = (matrixUDG.mMatrix[k][j]==Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + matrixUDG.mMatrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        System.out.printf("dijkstra(%c): \n", matrixUDG.mVexs[vs]);
        for (int i=0; i < matrixUDG.mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", matrixUDG.mVexs[vs], matrixUDG.mVexs[i], dist[i]);
    }


    private static int[] dijkstra(int[][] matrix){
        // 从第一个顶点到其他顶点的距离
        int[] minDist = new int[matrix.length];
        Arrays.fill(minDist, 0);
        Boolean updata = true;
        while (updata){
            updata = false;
            for (int i=0; i<matrix.length; i++){
                for (int j=0; j<matrix.length; j++){
                    if (matrix[i][j] == -1 || matrix[i][j] == 0) {
                        continue;
                    }else {
                        if (minDist[j] == -1) {
                            minDist[j] = minDist[i] + matrix[i][j];
                            updata = true;
                        }else {
                            if (minDist[j] > minDist[i]+matrix[i][j]){
                                minDist[j] = minDist[i]+matrix[i][j];
                                updata = true;
                            }
                        }
                    }
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 12, -1, -1, -1},
                          {-1, 0, 9, 3, -1, -1},
                          {-1, -1, 0, -1, 5, -1},
                          {-1, -1, 4, 0, 13, 15},
                          {-1, -1, -1, -1, 0, 4},
                          {-1, -1, -1, -1, -1, 0}};
        int[] res = dijkstra(matrix);
        for (int re : res) {
            System.out.println(re);
        }
    }


}
