package Basic.BasicSort.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/12 13:44
 * 二分法查找最大值问题
 */
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    // 获取随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Random length
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
