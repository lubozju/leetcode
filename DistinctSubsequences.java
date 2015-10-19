/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    public int numDistinct(String s, String t) {
        int[] help = new int[t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            int pre = 1;
            for (int j = 1; j < t.length() + 1; j++) {
                char sc = s.charAt(i - 1);
                char tc = t.charAt(j - 1);
                 if (sc != tc) {
                    help[j] = help[j];
                    pre = help[j];
                } else {
                    int temp = help[j];
                    help[j] = help[j] + pre;
                    pre = temp;
                }
            }
        }
        
        return help[t.length()];
    }
}