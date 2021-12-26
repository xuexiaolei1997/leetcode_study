package BasicImprove;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/12/26 19:07
 * 不使用if语句判断两数大小
 */
public class GetMax {
    /**
     * 保证参数n，不是1就是0
     * 1 -> 0
     * 0 -> 1
     *
     * @param n
     * @return
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    /**
     * 非负数返回1，负数返回0
     *
     * @param n
     * @return
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffSab = sa ^ sb; // a和b符号，不一样为1，一样为0
        int sameSab = flip(diffSab);  // a b 符号，一样为1，不一样为0
        int returnA = diffSab * sa + sameSab * sb;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147483641;
        System.out.println(getMax1(a, b));  // 溢出，所以输出错误
        System.out.println(getMax2(a, b));
    }
}
