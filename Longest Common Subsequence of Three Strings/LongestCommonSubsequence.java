// package Longest Common Subsequence of Three Strings;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence g = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(g.longestCommonSubsequence(text1,text2));
    }
}
