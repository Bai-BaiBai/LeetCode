package LeetCode;

/**
 * 62.不同路径
 */
public class Solution_62 {

    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePath(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(Solution_62.uniquePath(7, 3));
    }
}
