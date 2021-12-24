package Basic.BasicSort.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/12 13:59
 * 小和问题
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) return 0;
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;
        int res = 0;

        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;  // 未来有几个比它大
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) help[i++] = arr[p1++];

        while (p2 <= R) help[i++] = arr[p2++];

        for (i = 0; i < help.length; i++) arr[L + i] = help[i];

        return res;
    }

    public static void main(String[] args) {
//        int[] arr = utils.generateRandomArray(10, 10);
        int[] arr = {2, 2, 2, 2, 5};

        System.out.println("Ori sum:");
        for (int i = 0; i < arr.length; i++)  System.out.println(arr[i]);

        System.out.println("Sorted sum:");
        for (int i = 0; i < arr.length; i++)  System.out.println(arr[i]);

        System.out.println("smallSum:" + smallSum(arr));
    }
}
