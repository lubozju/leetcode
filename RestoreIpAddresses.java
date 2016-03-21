/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        
        dfs(s, 0, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void dfs(String s, int i, List<String> ip, List<String> result) {

        if (ip.size() == 4 && i == s.length()) {
            StringBuilder temp = new StringBuilder();
            for (String num : ip) {
                temp.append(num + ".");
            }
            temp.deleteCharAt(temp.length() - 1);
            result.add(temp.toString());
            return;
        }
        
        if (ip.size() == 4 || i == s.length()) {
            return;
        }
        
        if (s.charAt(i) == '0') {
            ip.add("0");
            dfs(s, i + 1, ip, result);
            ip.remove(ip.size() - 1);
        } else {
            for (int j = 0; i + j < s.length(); j++) {
                String sub = s.substring(i, i + j + 1);
                if (j < 2) {
                    ip.add(sub);
                    dfs(s, i + j + 1, ip, result);
                    ip.remove(ip.size() - 1);
                }
                if (j == 2) {
                    if(Integer.parseInt(sub) <= 255) {
                        ip.add(sub);
                        dfs(s, i + j + 1, ip, result);
                        ip.remove(ip.size() - 1);
                    }
                }
            }
        }
    }
}