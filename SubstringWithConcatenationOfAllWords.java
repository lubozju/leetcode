/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (String word : words) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }
        int wordLength = words[0].length();
        int length = wordLength * words.length;
        

        for (int i = 0; i < s.length() - length + 1; i++) {
            if (check(s.substring(i, i + length), wordLength, new HashMap<String, Integer>(map))) {
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean check(String sb, int wordLength, Map<String, Integer> map) {
        for (int i = 0; i < sb.length() - wordLength + 1; i += wordLength) {
            String word = sb.substring(i, wordLength + i);
            Integer count = map.get(word);
            if (count == null || count == 0) {
                return false;
            }
            map.put(word, count - 1);
        }
        return true;
    }
}