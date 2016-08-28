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



public class Solution {
    public boolean isMatch(String s, String p) {
        
        // Time: O(s.length() * p.length())
        // Time: O(s.length() * p.length())
        // dp[i][j]: s.substring(i), p.substring(j)
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                char pc = p.charAt(j);
                if (pc == '*') {
                    continue;
                }
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    if (i == s.length()) {
                        dp[i][j] = dp[i][j + 2];
                    } else {
                        char sc = s.charAt(i);
                        if (sc == pc || pc == '.') {
                            dp[i][j] = dp[i][j + 2] || dp[i + 1][j + 2] || dp[i + 1][j];
                        } else {
                            dp[i][j] = dp[i][j + 2];
                        }
                    }
                } else {
                    if (i == s.length()) {
                        dp[i][j] = false;
                    } else {
                        char sc = s.charAt(i);
                        if (pc == '.') {
                            dp[i][j] = dp[i + 1][j + 1];
                        } else {
                            dp[i][j] = (pc == sc) && dp[i + 1][j + 1];
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }
}


