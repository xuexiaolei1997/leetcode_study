package BasicImprove;

/**
 * @Author: xuexiaolei
 * @DATE: 2022/1/2 18:30
 * 动态规划，跳象棋
 */
public class dp {
    /**
     * 从(0,0)位置出发，去往(x,y)位置，必须跳step步，返回方法数
     *
     * @param x
     * @param y
     * @param step
     * @return
     */
    public static int process(int x, int y, int step) {
        if (x < 0 || y > 8 || y < 0 || y > 9) return 0;
        if (step == 0) return (x == 0 && y == 0) ? 1 : 0;
        return process(x - 1, y + 2, step - 1) +
                process(x - 2, y + 1, step - 1) +
                process(x - 1, y - 2, step - 1) +
                process(x - 2, y - 1, step - 1) +
                process(x + 1, y + 2, step - 1) +
                process(x + 2, y + 1, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x + 2, y - 1, step - 1);
    }

    public static int dpWays(int x, int y, int step) {
        if (x < 0 || y > 8 || y < 0 || y > 9 || step < 0) return 0;
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h <= step; h++) { // 层
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 10; c++) {
                    dp[r][c][h] += getValue(dp, r - 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c + 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c - 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c - 1, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c + 1, h - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    public static int getValue(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) return 0;
        return dp[row][col][step];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(dpWays(x, y, step));
    }
}
