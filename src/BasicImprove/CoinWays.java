package BasicImprove;

/**
 * @Author: xuexiaolei
 * @DATE: 2022/1/2 19:30
 * 最小货币数
 */
public class CoinWays {
    /**
     * arr 正数 无重复值
     * 每一个值代表一种货币，每一种都可以用无限张
     * 最终要找的零钱数是aim
     * 返回找零方法数
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) return rest == 0 ? 1 : 0;
        int ways = 0;
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }

    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return 0;
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col <= aim; col++) {
                int ways = 0;
                for (int zhang = 0; arr[row] * zhang <= col; zhang++) {
                    ways += dp[row + 1][col - arr[row] * zhang];
                }
                dp[row][col] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return 0;
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col <= aim; col++) {
                dp[row][col] = dp[row + 1][col];
                if (col - arr[row] >= 0) {
                    dp[row][col] += dp[row][col - arr[row]];
                }
            }
        }
        return dp[0][aim];
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Random length
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int aim = 100;
        if (way1(arr, aim) != way2(arr, aim)) {
            System.out.println("ooops!");
        }
//        int len = 10;
//        int max = 10;
//        int testTime = 1;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = generateRandomArray(len, max);
//            int aim = (int) (Math.random() * 3 * max) + max;
//            System.out.println(way2(arr, aim));
//             //传统方法与动态规划
//            if (way1(arr, aim) != way2(arr, aim)) {
//                System.out.println("ooops!");
//                break;
//            }
//        }
    }
}
