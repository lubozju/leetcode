/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int div = (n - 1) / 26;
        sb.append((char)('A' + (n - 1) % 26));
        while (div != 0) {
            int temp = (div - 1) / 26;
            sb.append((char)('A' + (div - 1) % 26));
            div = temp;
        }
        
        return sb.reverse().toString();
    }
}