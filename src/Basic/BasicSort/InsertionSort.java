package Basic.BasicSort;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 12:28
 * 插入排序
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length; i++)
            // 前面大于后面时，交换
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--)
                swap(arr, j, j + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 1, 4, 2, 8, 5};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
