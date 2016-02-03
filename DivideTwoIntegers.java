/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        long dividendLong = dividend;
        long divisorLong = divisor;
        
        boolean pos = true;
        
        if (dividendLong > 0 && divisorLong < 0 || dividendLong < 0 && divisorLong > 0) {
            pos = false;
        }
        
        if (dividendLong < 0) {
            dividendLong = -dividendLong;
        }
        
        if (divisorLong < 0) {
            divisorLong = -divisorLong;
        }
        
        long result = 0;

        while (dividendLong >= divisorLong) {
            long tempDivisor = divisorLong;
            int count = 1;
            while (dividendLong >= tempDivisor) {
                dividendLong -= tempDivisor;
                result += count;
                tempDivisor += tempDivisor;
                count += count;
            }
        }
        
        if (pos) {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)result;
        }
        return -(int)result;
    }
}