/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

*/

public class Solution {
    public int longestValidParentheses(String s) {
        // dp[i] the longest valid parenthese end at i - 1
        int[] dp = new int[s.length() + 1];
        
        int result = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i + 1] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i + 1] = 2 + dp[i - 1];
                } else {
                    int length = dp[i];
                    if (i - length - 1 >= 0 && s.charAt(i - length - 1) == '(') {
                        dp[i + 1] = 2 + length + dp[i - length - 1];
                    }
                }
                if (result < dp[i + 1]) {
                    result = dp[i + 1];
                }
            }
        }
        return result;
    }
}