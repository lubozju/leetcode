/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] cArray = s.toCharArray();
        
        int result = 0;
        
        for (int i = 0; i < cArray.length; i++) {
            result = 26 * result + (cArray[i] - 'A' + 1);
        }
        
        return result;
    }
}


public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] cArray = s.toCharArray();
        
        int result = 0;
        
        for (int i = 0; i < cArray.length; i++) {
            result += (cArray[i] - 'A' + 1) * Math.pow(26, cArray.length - i - 1);
        }
        
        return result;
    }
}