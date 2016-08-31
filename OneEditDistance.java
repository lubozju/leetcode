/*
Given two strings S and T, determine if they are both one edit distance apart.
*/

public class Solution {
    // Time O(n)
    // Space O(1)
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        
        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }
        
        if (sLength == tLength) {
            int countDiff = 0;
            for (int i = 0; i < sLength; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    countDiff++;
                    if (countDiff > 1) {
                        return false;
                    }
                }
            }
            return countDiff == 1;
        }
        if (sLength > tLength) {
            String temp = s;
            s = t;
            t = temp;
        }
        
        // s is shorter
        
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (i == j) {
                    j++;
                } else {
                    return false;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}

public class Solution {
    // Time O(n)
    // Space O(1)
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        
        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }
        
        for (int i = 0; i < Math.min(sLength, tLength); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLength == tLength) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                if (sLength < tLength) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return Math.abs(sLength - tLength) == 1;
    }
}