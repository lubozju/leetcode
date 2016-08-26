/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/

public class Solution {
    // Time O(n)
    // Space O(1)
    public void reverseWords(char[] s) {
        int start = 0;
        int end = start;
        while (end < s.length) {
            if (s[end] != ' ') {
                end++;
            } else {
                reverseWord(s, start, end - 1);
                start = end + 1;
                end = start;
            }
        }
        reverseWord(s, start, end - 1);
        reverseWord(s, 0, s.length - 1);
    }
    
    private void reverseWord(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}