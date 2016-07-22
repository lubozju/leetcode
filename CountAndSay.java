/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    // Time O(n)
    // Space O(1)
    public String countAndSay(int n) {
        String sb = "1";
        while (n > 1) {
            StringBuilder temp = new StringBuilder();
            int digit = 0;
            int count = 1;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) - '0' != digit) {
                    if (digit != 0) {
                        temp.append(count);
                        temp.append(digit);
                    }
                    digit = sb.charAt(i) - '0';
                    count = 1;
                } else {
                    count++;
                }
            }
            temp.append(count);
            temp.append(digit);
            sb = temp.toString();
            n--;
        }
        return sb;
    }
}