package Basic.BasicSort.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/22 15:41
 * 二分法查找，前提：有序数组
 */
public class BiSearch {
    public int biSearch(int[] arr, int L, int R, int num) {
        int res = process(arr, L, R, num);
        return res;
    }

    public int process(int[] arr, int L, int R, int num) {
        int res = -1;
        if (L == R) return res;
        if (arr[L] == num) return L;
        if (arr[R] == num) return R;

        int mid = L + ((R - L) >> 1);
        if (arr[L] < num){
            res = process(arr, L, mid, num);
        }else if (arr[L] > num){
            res =  process(arr, mid + 1, R, num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        BiSearch biSearch = new BiSearch();
        int res = biSearch.biSearch(arr, 0, arr.length - 1, 1);
        System.out.println(res);
    }
}
