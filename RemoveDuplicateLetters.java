/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']--; // the number of char left
            
            if (visited[c - 'a'] == true) {
                continue;
            }
  
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && counts[sb.charAt(sb.length() - 1) - 'a'] != 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            visited[c - 'a'] = true;
        }
        
        return sb.toString();
    }
}
