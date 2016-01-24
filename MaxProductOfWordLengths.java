/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

public class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            boolean[] letters = new boolean[26];
            for (int m = 0; m < words[i].length(); m++) {
                letters[words[i].charAt(m) - 'a'] = true;
            }
            for (int j = i + 1; j < words.length; j++) {
                int n;
                for (n = 0; n < words[j].length(); n++) {
                    if (letters[words[j].charAt(n) - 'a']) {
                        break;
                    }
                }
                if (n == words[j].length()) {
                    int temp = words[i].length() * words[j].length();
                    if (temp > result) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}