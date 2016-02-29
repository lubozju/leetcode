/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        
        return help(s, 0, wordDict, map);
    }
    
    private List<String> help(String s, int index, Set<String> wordDict, Map<Integer, List<String>> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        
        if (index == s.length()) {
            List<String> list = new ArrayList<String>();
            list.add("");
            return list;
        }
        
        List<String> result = new ArrayList<String>();
        for (int i = index; i < s.length(); i++) {
            String word = s.substring(index, i + 1);
            if (wordDict.contains(word)) {
                List<String> temp = help(s, i + 1, wordDict, map);
                for (String olds : temp) {
                    String news;
                    if (olds.length() > 0) {
                        news = word + " " + olds;
                    } else {
                        news = word;
                    }
                    result.add(news);
                }
            }
        }
        map.put(index, result);
        return result;
    }
}