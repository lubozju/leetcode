/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        String result = s;
        
        int max = 1;
        for (int i = 1; i < s.length() - 1; i++) {
            int size = 1;
            int left = i - size;
            int right = i + size;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                size++;
                left = i - size;
                right = i + size;
            }
            if (max < 2 * size - 1) {
                result = s.substring(left + 1, right);
                max = 2 * size - 1;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            int size = 0;
            int left = i - size;
            int right = i + 1 + size;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                size++;
                left = i - size;
                right = i + 1 + size;
            }
            if (max < 2 * size) {
                result = s.substring(left + 1, right);
                max = 2 * size;
            }
        }
        return result;
    }
}