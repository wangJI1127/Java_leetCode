package lintCode;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

public class _96_Unique_Binary_Search_Trees {
    // 动态规划
    public int numTrees(int n) {
        int [] arr = new int[n+1];
        arr[0] = 1; //空树代表一种 排序树
        arr[1] = 1;
        for(int i=2; i<=n; i++){
            for (int j=1; j<=i; j++){
                arr[i] += arr[j-1] * arr[i-j];
            }
        }
        return arr[n];
    }

    /**
     * 事实上 G(n)G(n)G(n)函数的值被称为 卡塔兰数 CnC_nCn​。卡塔兰数更便于计算的定义如下:
     *
     * C0​=1,  Cn+1​=2(2n+1)​Cn​/(n+2)
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numTrees1(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
