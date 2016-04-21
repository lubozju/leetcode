/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (same(haystack, i, needle)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean same(String haystack, int i, String needle) {
        for (int j = 0; j < needle.length(); j++) {
            if (haystack.charAt(j + i) != needle.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}