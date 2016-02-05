/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        return help(s, p, new HashMap<List<String>, Boolean>());
    }
    
    private boolean help(String s, String p, Map<List<String>, Boolean> cache) {
        List<String> list = new ArrayList<String>();
        list.add(s);
        list.add(p);
        
        if (cache.containsKey(list)) {
            return cache.get(list);
        }
        
        boolean result;
        if (s.length() == 0) {
            if (p.length() > 1 && p.charAt(1) == '*') {
                result = help(s, p.substring(2), cache);
                cache.put(list, result);
                return result;
            } else {
                return p.length() == 0;
            }
        }
        if (p.length() == 0) {
            return false;
        }
        
        char sc = s.charAt(0);
        char pc = p.charAt(0);

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (sc == pc || pc == '.') {
                result = help(s.substring(1), p.substring(2), cache) || help(s, p.substring(2), cache) || help(s.substring(1), p, cache);
            } else {
                result = help(s, p.substring(2), cache);
            }
        } else {
            if (sc == pc || pc == '.') {
                result = help(s.substring(1), p.substring(1), cache);
            } else {
                result = false;
            }
        }
        
        cache.put(list, result);
        
        return result;
    }
}