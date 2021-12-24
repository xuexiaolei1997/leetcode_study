package Basic.BasicSort.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/21 21:25
 * 荷兰国旗问题
 */
public class NetherLandsFlag {

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (less < more - 1) {
            if (arr[L] < num) {
                swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 2, 32, 65, 21, 8};
        int[] res = partition(arr, 0, arr.length - 1, 9);
        for (int w : arr) System.out.print(w + " ");
        System.out.println();
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
