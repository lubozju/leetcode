/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return help(s1, s2, s3, new HashMap<List<String>, Boolean>());
    }
    
    private boolean help(String s1, String s2, String s3, Map<List<String>, Boolean> map) {
        List<String> temp = new ArrayList<String>();
        if (s1.compareTo(s2) < 0) {
            temp.add(s1);
            temp.add(s2);
        } else {
            temp.add(s2);
            temp.add(s1);
        }
        temp.add(s3);
        
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        
        char c3 = s3.charAt(0);
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        
        if (c3 != c1 && c3 != c2) {
            return false;
        }
        if (c3 == c1) {
            if (help(s1.substring(1), s2, s3.substring(1), map)) {
                map.put(temp, true);
                return true;
            }
        }
        if (c3 == c2) {
            if (help(s1, s2.substring(1), s3.substring(1), map)) {
                map.put(temp, true);
                return true;
            }
        }
        map.put(temp, false);
        return false;
        
    }
}