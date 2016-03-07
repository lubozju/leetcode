/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[0]  = 1;
        }
        
        for (int i = 1; i < s.length() + 1; i++) {
            int pre = dp[0];
            for (int j = 1; j < t.length() + 1; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = pre + dp[j];
                }
                pre = temp;
            }
        }
        return dp[t.length()];
    }
}