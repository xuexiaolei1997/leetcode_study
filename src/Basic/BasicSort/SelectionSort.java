package Basic.BasicSort;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/15 12:28
 * 选择排序
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length > 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 选择最大值索引
            for (int j = i + 1; j < arr.length; j++)
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


