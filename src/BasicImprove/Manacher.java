package BasicImprove;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/10/27 20:03
 * Manacher
 */
public class Manacher {

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int manLcpsLength(String s) {
        if (s == null || s.length() == 0) return 0;
        // 1221 -> #1#2#2#1#
        char[] str = manacherString(s);

        int[] pArr = new int[str.length];  // 回文半径数组
        int C = -1;  // 中心
        int R = -1;  // 回文右边界再往右的一个位置，最右的有效区是R-1位置
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != str.length; i++) {
            /**
             * i在R外，取1
             * i在R内，若i的回文半径在R外，则右边界取R，否则取i'
             */
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
}
