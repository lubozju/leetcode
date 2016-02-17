/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        char[] letters = pattern.toCharArray();
        
        if (words.length != letters.length) {
            return false;
        }
        
        String[] lToWord = new String[26];
        Map<String, Character> wordToL = new HashMap<String, Character>();
        
        for (int i = 0; i < letters.length; i++) {
            if(lToWord[letters[i] - 'a'] != null && !lToWord[letters[i] - 'a'].equals(words[i])) {
                return false;
            }
            if (wordToL.get(words[i]) != null && wordToL.get(words[i]) != letters[i]) {
                return false;
            }
            lToWord[letters[i] - 'a'] = words[i];
            wordToL.put(words[i], letters[i]);
        }
        return true;
    }
}