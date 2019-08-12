package 领扣;

import java.util.*;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _354_俄罗斯套娃信封问题_二维数组排序_动态规划 {
    public int maxEnvelopes(int[][] envelopes) {
        // 二维数组排序_动态规划
        if (envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]?o1[1] - o2[1]:o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int res = 1;
        for (int i=1; i<envelopes.length; i++){
            dp[i] = 1;
            for (int j=i-1; j>=0; j--){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3},{3,3}};
//        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() { // 默认升序
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1; // 降序
//                // return obj2.compareTo(obj1);  // String 类型的降序
//            }
//        });
//        for (int[] envelope : envelopes) {
//            if (map.containsKey(envelope[0])){
//                if (map.get(envelope[0]) < envelope[1]){
//                    map.put(envelope[0], envelope[1]);
//                }
//            }else {
//                map.put(envelope[0], envelope[1]);
//            }
//        }
//        for (Integer value : map.values()) {
//            System.out.println(value);
//        }

        List<List<Integer>> lists = new ArrayList<>();

        for (int[] envelope : envelopes) {
            List<Integer> list = new ArrayList<>();
            for (int i : envelope) {
                list.add(i);
            }
            lists.add(list);
        }
    }
}
