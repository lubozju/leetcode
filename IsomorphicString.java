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
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            Character st = map1.put(s.charAt(i), t.charAt(i));
            if (st != null && st != t.charAt(i)) {
                return false;
            }
            Character ts = map2.put(t.charAt(i), s.charAt(i));
            if (ts != null && ts != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public boolean isIsomorphic(String s, String t) {
       int[] counts = new int[256];
       int[] countt = new int[256];
       
       for (int i = 0; i < s.length(); i++) {
           if (counts[s.charAt(i)] != countt[t.charAt(i)]) {
               return false;
           } 
           counts[s.charAt(i)] = i + 1;
           countt[t.charAt(i)] = i + 1;
       }
       return true;
    }
}