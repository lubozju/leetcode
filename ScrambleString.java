/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<List<String>, Boolean> map = new HashMap<List<String>, Boolean>();
        return help(s1, s2, map);
    }
    
    private boolean help(String s1, String s2, Map<List<String>, Boolean> map) {
        List<String> key = new ArrayList<String>();
        key.add(s1);
        key.add(s2);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)]--;
            if (count[s2.charAt(i)] < 0) {
                map.put(key, false);
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            String s1l = s1.substring(0, i);
            String s2l = s2.substring(0, i);
            String s1r = s1.substring(i);
            String s2r = s2.substring(i);
            if (help(s1l, s2l, map) && help(s1r, s2r, map)) {
                map.put(key, true);
                return true;
            }
            s1l = s1.substring(0, i);
            s2r = s2.substring(s1.length() - i);
            s1r = s1.substring(i);
            s2l = s2.substring(0, s1.length() - i);
            if (help(s1l, s2r, map) && help(s1r, s2l, map)) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}