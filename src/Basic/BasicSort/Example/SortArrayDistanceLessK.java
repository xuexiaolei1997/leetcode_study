package Basic.BasicSort.Example;

import java.util.PriorityQueue;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/13 14:59
 * 条件：数组基本有序
 * 整个数组中，部分(k)使用堆排序，如数组长度为100，构建heapSize为7的堆，在原始数组进行滑动
 */
public class SortArrayDistanceLessK {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        // default small root heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty())
            arr[i++] = heap.poll();
    }

}
