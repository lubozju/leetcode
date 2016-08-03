/*
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
*/

public class Solution {
    // Time O(n)
    // Space O(1)
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int result = words.length;
        
        boolean sameWord = word1.equals(word2);
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1) {
                    if (sameWord || !words[i].equals(words[index])) {
                        result = Math.min(result, i - index);
                    }
                }
                index = i;
            }
        }
        return result;
    }
}