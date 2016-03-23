/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "qprs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> result = new ArrayList<String>();
        
        dfs(digits, 0, new String(), result, map);
        
        return result;
    }
    
    private void dfs(String digits, int index, String path, List<String> result, Map<Character, String> map) {
        if (index == digits.length()) {
            if (path.length() > 0) {
                result.add(path);
            }
            return;
        }
        
        char c = digits.charAt(index);
        for (char l : map.get(c).toCharArray()) {
            String temp = path + l;
            dfs(digits, index + 1, temp, result, map);
        }
    }
}