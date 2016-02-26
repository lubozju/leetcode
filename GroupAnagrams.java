/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            String key = sort(str);
            List<String> value = map.get(key);
            if (value == null) {
                value = new ArrayList<String>();
                map.put(key, value);
            }
            value.add(str);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> value : map.values()) {
            Collections.sort(value);
            result.add(value);
        }
        return result;
    }
    
    private String sort(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);
    }
}