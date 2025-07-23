// package Longest Common Subsequence of Three Strings;

public class LongestCommonSubsequenceBruteForce {
    public int lcs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcs(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(
                lcs(text1, text2, i + 1, j),
                lcs(text1, text2, i, j + 1)
            );
        }
    }
    public static void main(String[] args) {
        LongestCommonSubsequenceBruteForce g = new LongestCommonSubsequenceBruteForce();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(g.lcs(text1, text2, 0, 0)); 
    }
}
