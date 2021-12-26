package BasicImprove;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/12/26 20:57
 * 加减乘除实现
 */
public class AddMinusMultiDivideByBit {
    /**
     * 1、a b 异或运算 -> 无进位相加
     * 2、a b 与运算后左移一位，得出进位信息
     * 3、1与2相加
     * 4、重复123直到进位信息为0
     * 注意：如果a+b是溢出的，则报错
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    /**
     * 二进制乘法与十进制乘法一样
     * 如果被乘数当前位置为1，则加，为0则不加
     *
     * @param a
     * @param b
     * @return
     */
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }


}
