package Basic.BasicSort;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/14 11:12
 * 桶排序
 */
public class RadixSort {
    // only for positive value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    // 数组中最大值的位数
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;  // 十进制
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];

        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];

            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];  // 每个数字前面比它小的总个数
            }

            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];  // 放入桶中
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    // 获取数字x的第i位，从右往左数
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = {1,23,56,787,4,2,34,65,234,546};
        radixSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
