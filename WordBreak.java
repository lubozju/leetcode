/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    //Time: O(s.length() * s.length())
    //Space: O(s.length())
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0;j--) {
                String sb = s.substring(j, i + 1);
                if (wordDict.contains(sb)) {
                    dp[i + 1] = dp[j];
                    if (dp[i + 1]) {
                        // once we find break, search for dp[i + 1] is done
                        break;
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
}
