package LeetCode;

/**
 * 最长回文子串
 */
public class Solution_5 {

    // dp解法
    // 思路是 如果第i个字符到第j个字符为回文，则第i+1个字符到第j-1个字符一定也是回文
    public String longestPalindrome_dp(String s) {
        int n = s.length();

        if (n < 2) {
            return s;
        }

        char[] array = s.toCharArray();
        int start = 0;
        int maxLength = 1;

        // dp[i][j]代表第i个字符到第j个字符是不是回文
        boolean[][] dp = new boolean[n][n];

        // 单个字符一定为回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (array[i] == array[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && j - i > maxLength) {
                        start = i;
                        maxLength = j - i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);

    }

    // 数组 剪枝求解
    // 利用回文特性，将回文中间的字符看做是一个字符
    public String longestPalindrome_array(String s) {

        int n = s.length();
        if (n < 2) {
            return s;
        }

        char[] array = s.toCharArray();
        int[] range = new int[2];

        for (int i = 0; i < n; i++) {
            i = findLongest(array, i, range);
        }

        return s.substring(range[0], range[1] + 1);
    }

    public int findLongest(char[] array, int low, int[] range) {
        int high = low;

        // 向右找同一字符
        while (high < array.length - 1 && array[high + 1] == array[low]) {
            high++;
        }

        // 记录最后一个相同字符的位置，下一次从这里开始
        int ans = high;

        // 两边扩展，看是否满足回文
        while (high < array.length - 1 && low > 0 && array[low - 1] == array[high + 1]) {
            high++;
            low--;
        }

        // 对比上次记录，看是否是最长回文，并记录下标
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }

        return ans;
    }

    public static void main(String[] args) {


    }
}
