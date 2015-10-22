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
        String[] words = str.split("\\s");
        
        char[] charArray = pattern.toCharArray();
        
        if (words.length != charArray.length) {
            return false;
        }
        
        Map<String, Character> map1 = new HashMap<String, Character>();
        Map<Character, String> map2 = new HashMap<Character, String>();
        
        for (int i = 0; i < words.length; i++) {
            Character c = map1.get(words[i]);
            String word = map2.get(charArray[i]);
            if (c == null) {
                map1.put(words[i], charArray[i]);
            } else {
                if (c != charArray[i]) {
                    return false;
                }
            }
            
            if (word == null) {
                map2.put(charArray[i], words[i]);
            } else {
                if (!word.equals(words[i])) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}