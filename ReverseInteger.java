/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class Solution {
    // Time O(number of digits)
    // Space O(1)
    public int reverse(int x) {
        int limit = Integer.MAX_VALUE;
        if (x < 0) {
            limit = Integer.MIN_VALUE;
        }
        int num = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            // lastDigit is negtive when x is negtive
            if (limit > 0) {
                if (num > (limit - lastDigit) / 10) {
                    return 0;
                }
            } else {
                if (num < (limit - lastDigit) / 10) {
                    return 0;
                }
            }
            num = num * 10 + lastDigit;
            x = x / 10;
        }
        return num;
    }
}