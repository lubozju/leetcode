/*
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        initMap(map, words);
    }
    
    // Time O(n)
    // Space O(n)
    private void initMap(Map<String, List<Integer>> map, String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> indexes = map.get(words[i]);
            if (indexes == null) {
                indexes = new ArrayList<Integer>();
                map.put(words[i], indexes);
            }
            indexes.add(i);
        }
    }
    // Time O(n)
    public int shortest(String word1, String word2) {
        List<Integer> indexes1 = map.get(word1);
        List<Integer> indexes2 = map.get(word2);
        
        int index1 = 0;
        int index2 = 0;
        int result = Integer.MAX_VALUE;
        while (index1 < indexes1.size() && index2 < indexes2.size()) {
            int temp1 = indexes1.get(index1);
            int temp2 = indexes2.get(index2);
            result = Math.min(result, Math.abs(temp1 - temp2));
            if (temp1 > temp2) {
                index2++;
            } else {
                index1++;
            }
        }
        
        return result;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");