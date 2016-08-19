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

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int hN = 0;
        int hH = 0;
        for (int i = 0; i < needle.length(); i++) {
            hN += needle.charAt(i);
            hH += haystack.charAt(i);
        }
        
        int start = 0;
        int end = needle.length() - 1;
        end++;
        while (end < haystack.length()) {
            if (hN == hH) {
                if (check(haystack, needle, start)) {
                    return start;
                }
            }
            hH = hH - haystack.charAt(start) + haystack.charAt(end);
            end++;
            start++;
        }
        if (hN == hH) {
            if (check(haystack, needle, start)) {
                return start;
            }
        }
        return -1;
    }
    private boolean check(String haystack, String needle, int start) {
        int i = 0;
        while (i < needle.length() && haystack.charAt(start + i) == needle.charAt(i)) {
            i++;
        }
        return i == needle.length();
    }
    
}