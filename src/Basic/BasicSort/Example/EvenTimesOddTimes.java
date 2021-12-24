package Basic.BasicSort.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/11 22:13
 * 数字出现奇偶次数问题
 */

public class EvenTimesOddTimes {

    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        /**
         * XOR operation.
         * Examples:
         * A ^ A = 0
         * A ^ 0 = A
         * A ^ B ^ B = A
         */
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;

        for (int cur : arr) eor ^= cur;

        /**
         * All numbers are XORed and then combined with one's complement.
         * Examples:
         * A      =    100110
         * ~A+1   =    011010
         * A & (~A+1): 000010
         */
        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;

        /**
         * Search the number which the pos is one
         * for example:
         * Target number: 000010
         * 100010 will fit the condition but 111101 won't
         *
         */
        for (int cur : arr)
            if ((cur & rightOne) == 0)
                onlyOne ^= cur;

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
