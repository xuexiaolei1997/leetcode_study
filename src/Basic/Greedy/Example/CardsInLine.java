package Basic.Greedy.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/22 10:09
 * 拿纸排得分
 */
public class CardsInLine {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    public static int s(int[] arr, int L, int R) {
        if (L == R) return 0;
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };
        System.out.println(win1(arr));
    }
}
