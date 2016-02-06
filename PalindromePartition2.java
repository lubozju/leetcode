/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] dpPalin = new boolean[s.length()][s.length()];
        
        for (int d = 0; d < s.length(); d++) {
            for (int left = 0; left < s.length() - d; left++) {
                int right = left + d;
                if(d == 0) {
                    dpPalin[left][right] = true;
                } else if (d == 1){
                    dpPalin[left][right] = s.charAt(left) == s.charAt(right);
                } else {
                    dpPalin[left][right] = (s.charAt(left) == s.charAt(right)) && dpPalin[left + 1][right - 1];
                }
            }
        }
        
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (dpPalin[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = i; j > 0; j--) {
                    if (dpPalin[j][i]) {
                        int temp = 1 + dp[j - 1];
                        if (temp < dp[i]) {
                            dp[i] = temp;
                        }
                    }
                }
            }
        }
        
        return dp[s.length() - 1];
    }
}