/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s3.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = dp[i][0];
            }
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                int k = i + j - 1;
                if (s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}