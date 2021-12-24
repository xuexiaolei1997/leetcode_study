package BasicImprove;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/24 21:03
 * KMP算法
 */
public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;  // 主串索引
        int i2 = 0;  // 子串索引
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) { // 匹配成功，都右移
                i1++;
                i2++;
            } else if (next[i2] == -1) { // 匹配失败，且没有公共前缀
                i1++;
            } else { // 匹配失败，找前缀
                i2 = next[i2];
            }
        }
        // 当i2达到末尾时，表明匹配成功
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) return new int[]{-1};
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;  // 当前遍历位置
        int cn = 0;  // 前缀所在位置
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) { // 匹配成功，都右移
                next[i++] = ++cn;
            } else if (cn > 2) { // 匹配失败，前缀大于2，从next数组中继续找
                cn = next[cn];
            } else {  // 匹配失败，右侧右移
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aabbccaabbccaabbaacbbaac";
        String m = "bbccaab";
        int a = getIndexOf(s, m);
        System.out.println(a);
    }
}
