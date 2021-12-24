package Basic.Greedy.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/20 17:57
 * 八皇后问题
 */
public class NQueens {
    public static int num1(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process1(0, record, n);
    }

    /**
     * @param i      目前来到第几行
     * @param record 表示之前放了皇后的位置
     * @param n      整体有多少行
     * @return 摆完所有的皇后，合理的摆法有多少种
     */
    public static int process1(int i, int[] record, int n) {
        if (i == n) return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static int num2(int n) {
        if (n < 1 || n > 32) return 0;
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) return 1;
        int mostTightOne = 0;
        // 皇后候选的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostTightOne = pos & (~pos + 1);
            pos = pos - mostTightOne;
            // >> 右移， >>> 无符号右移，忽略符号位，空位补0
            res += process2(limit, colLim | mostTightOne, (leftDiaLim | mostTightOne) << 1, (rightDiaLim | mostTightOne) >>> 1);
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++)
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int a = num2(8);
        System.out.println(a);
        int b = num1(8);
        System.out.println(b);
    }
}
