package Basic.BasicSort;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/12 14:37
 * 快速排序
 */
public class QuickSort {
    /**
     * quick sort func
     *
     * @param arr array need to sort
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * QuickSort's Specific Function Implements.
     * 1. Random search a item between index L and R, and then exchange this item'loc with arr[R].
     * 2. Divide arr[L:R] to [L:p0] and [p1:R].
     * 3. Sort array divided by previous step.
     *
     * @param arr array need to sort
     * @param L   left index
     * @param R   right index
     */
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            // 原本是以最后一个值作为R，现在改为随机选取，理论上会有些许加速
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * Divide array to three areas(less,equal,more).
     *
     * @param arr array
     * @param L   Used as cur left point index
     * @param R   arr[R] be treated as a Sentry
     * @return
     */
    public static int[] partition(int[] arr, int L, int R) {
        // less area index
        int less = L - 1;

        // more area index
        int more = R;

        while (L < more) {
            if (arr[L] < arr[R])
                swap(arr, ++less, L++);  // less area ++, left index ++
            else if (arr[L] > arr[R])
                swap(arr, --more, L);    // more area ++, right index --
            else
                L++;                     // min area be patient, left index ++
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 1, 2, 8, 32, 65, 21};
        quickSort(a);
        for (int w : a) System.out.println(w);
    }
}
