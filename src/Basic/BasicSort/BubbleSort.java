package Basic.BasicSort;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 12:28
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int e = arr.length; e > 0; e--)
            for (int i = 0; i < e; i++)
                if (arr[i] > arr[i + 1])  swap(arr, i, i + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
