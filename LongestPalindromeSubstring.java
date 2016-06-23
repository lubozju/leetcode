/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    // Time: (n^2)
    // Space: (n)
    public String longestPalindrome(String s) {
        String oddPalin = findOdd(s);
        String evenPalin = findEven(s);
        return oddPalin.length() > evenPalin.length() ? oddPalin : evenPalin;
    }
    
    private String findOdd(String s) {
        String result = new String();
        // i is center
        for (int i = 0; i < s.length(); i++) {
            int k = 1;
            while (i - k >= 0 && i + k < s.length()) {
                if (s.charAt(i - k) == s.charAt(i + k)) {
                    k++;
                } else {
                    break;
                }
            }
            if (result.length() < 2 * (k - 1) + 1) {
                result = s.substring(i - (k - 1), i + k);
            }
        }
        return result;
    }
    
    private String findEven(String s) {
        String result = new String();
        // i, i + 1 are center
        for (int i = 0; i < s.length() - 1; i++) {
            // k = 0 since i and i + 1 needs to be checked
            int k = 0;
            while (i - k >= 0 && i + 1 + k < s.length()) {
                if (s.charAt(i - k) == s.charAt(i + 1 + k)) {
                    k++;
                } else {
                    break;
                }
            }
            if (result.length() < 2 * (k - 1) + 2) {
                result = s.substring(i - (k - 1), i + 1 + k);
            }
        }
        return result;
    }
}