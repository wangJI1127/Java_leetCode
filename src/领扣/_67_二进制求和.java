package 领扣;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _67_二进制求和 {
    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        int head = 0;
        StringBuilder res = new StringBuilder();
        while (n >= 0 && m >= 0) {
            int sum = head + a.charAt(n) - '0' + b.charAt(m) - '0';
            head = sum / 2;
            res.insert(0, sum % 2);
            n--;
            m--;
        }
        while (n >= 0) {
            int sum = head + a.charAt(n) - '0';
            head = sum / 2;
            res.insert(0, sum % 2);
            n--;
        }
        while (m >= 0) {
            int sum = head + b.charAt(m) - '0';
            head = sum / 2;
            res.insert(0, sum % 2);
            m--;
        }
        if (head == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}
