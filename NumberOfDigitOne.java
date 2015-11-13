/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
*/

public class Solution {
    public int countDigitOne(int n) {
        int base = 1;
        int result = 0;
        while (n / base > 0) {
            if (Integer.MAX_VALUE / 10 < base) {
                if (n / base > 1) {
                    result += base;
                } else {
                    result += (n % base) + 1;
                }
                break;
            }
            
            int nextBase = base * 10;
            result += n / nextBase * base;
            int res = n % nextBase;
            if (res >= base) {
                if (res / base > 1) {
                    result += base;
                } else {
                    result += (res % base) + 1;
                }
            }
            base = nextBase;
        }
        
        return result;    
    }
}