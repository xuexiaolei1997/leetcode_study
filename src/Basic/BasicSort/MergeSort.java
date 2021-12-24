package Basic.BasicSort;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/12 13:48
 * 归并
 * 递归在于划分问题，找到子问题的通用解决方式
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) return;

        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);  // 左
        process(arr, mid + 1, R);  // 右
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        // 辅助数组
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;

        // 谁小谁进
        while (p1 <= M && p2 <= R)
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];

        // 只会走下面一个while
        while (p1 <= M) help[i++] = arr[p1++];
        while (p2 <= R) help[i++] = arr[p2++];

        // 放入原数组
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 234, 4, 565, 23, 123, 75};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
