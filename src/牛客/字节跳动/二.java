package 牛客.字节跳动;
/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/15
 * @Modifited By:
 */

import java.util.*;

/**
 * @ClassName:二
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/15 15:50
 * @Version:1.0
 **/
public class 二 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Long, Long> map = new TreeMap<>();
        for (int i=0; i<n; i++){
            long key = in.nextLong();
            long value = in.nextLong();
            map.put(key, map.getOrDefault(key, 0L)+value);
        }
        Long minTime = 0L;
        for(long i=0; i<Long.MAX_VALUE; i++){
            if (map.containsKey(i)){
                minTime = i;
                break;
            }
        }
        long queue = map.get(minTime);
        long max = queue;
        long time = minTime;
        while (queue > 0 || map.size()>0){
            queue--;
            time++;
            if (map.containsKey(time)){
                queue += map.get(time);
                map.remove(time);
            }
            max = Math.max(max, queue);
        }
        System.out.println(time + " " + max);
    }
}
