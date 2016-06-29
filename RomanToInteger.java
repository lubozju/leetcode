/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    // Time O(n)
    // Time O(1)
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            if (i + 1 < s.length()) {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                    result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i = i + 2;
                } else {
                    result += map.get(s.charAt(i));
                    i++;
                }
            } else {
                result += map.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}