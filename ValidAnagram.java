/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char cs : s.toCharArray()) {
            count[cs - 'a']++;
        }
        for (char ct : t.toCharArray()) {
            count[ct - 'a']--;
            if (count[ct - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (char cs : s.toCharArray()) {
            if (count.get(cs) == null) {
                count.put(cs, 1);
            } else {
                count.put(cs, count.get(cs) + 1);
            }
        }
        
        for (char ct : t.toCharArray()) {
            if (count.get(ct) == null || count.get(ct) == 0) {
                return false;
            }
            count.put(ct, count.get(ct) - 1);
        }
        return true;
    }
}
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        Arrays.sort(sc);
        Arrays.sort(tc);
        
        return Arrays.equals(sc, tc);
    }
}ß