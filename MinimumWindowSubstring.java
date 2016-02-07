/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[256];
        
        for (int i = 0; i < t.length(); i++) {
            count[(int)(t.charAt(i))]++;
        }
        
        int start = 0;
        int end = 0;
        
        int total = t.length();
        
        String result = "";
        int minSize = s.length() + 1;
        while (end < s.length()) {
            if (count[(int)(s.charAt(end))] > 0) {
                total--;
            }
            count[(int)(s.charAt(end))]--;
            end++;
            while (total == 0) {
                if (minSize > end - start) {
                    minSize = end - start;
                    result = s.substring(start, end);
                }
                // char in t
                if (count[(int)(s.charAt(start))] >= 0) {
                    total++;
                }
                count[(int)(s.charAt(start))]++;
                start++;
            }
        }
        
        return result;
    }
}