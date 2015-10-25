/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            Character ctMap = map1.get(cs);
            if (ctMap != null) {
                if (ctMap != ct) {
                    return false;
                }
            } else {
                map1.put(cs, ct);
            }
            
            Character csMap = map2.get(ct);
            if (csMap != null) {
                if (csMap != cs) {
                    return false;
                }
            } else {
                map2.put(ct, cs);
            }
        }
    
        return true;
    }
}