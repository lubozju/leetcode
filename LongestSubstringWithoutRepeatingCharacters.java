/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;
        int end = 0;
        boolean noDuplicate = true;
        int[] count = new int[256];
        
        while (end < s.length()) {
            count[(int) s.charAt(end)]++;
            if (count[(int) s.charAt(end)] > 1) {
                noDuplicate = false;
            }
            end++;
            while (!noDuplicate) {
                count[(int) s.charAt(start)]--;
                if (count[(int) s.charAt(start)] == 1) {
                    noDuplicate = true;
                }
                start++;
            }
            if (result < end - start) {
                result = end - start;
            }
        }
        
        return result;
    }
}