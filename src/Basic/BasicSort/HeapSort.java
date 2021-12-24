package Basic.BasicSort;

import org.jetbrains.annotations.NotNull;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/12 22:22
 * 堆排序
 */
public class HeapSort {
    /**
     * 输入一个数组，构建一个堆
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // build heap 1
        for (int i = 0; i < arr.length; i++)
            heapInsert(arr, i);  // 每个位置进行插入

        // build heap 2
        for (int i = arr.length-1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * insert an item into heap and adjust it
     * @param arr
     * @param index
     */
    public static void heapInsert(int @NotNull [] arr, int index) {
        // 当前节点大于其父节点的值，如果为根节点，则和自己比，肯定相等，不大于，所以跳出
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;  // 往父节点走
        }
    }

    /**
     * adjust arr[index] in the heap
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        // 左孩子节点索引
        int left = index * 2 + 1;
        while (left < heapSize) {
            // largest index among root,l_child and r_child
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) break;  // 不需要调整，每次都保证是在堆的情况下，可直接跳出

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
