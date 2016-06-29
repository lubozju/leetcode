/**
*Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
*For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3
*
*/

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            count += n & 1; //check the right most bit
            n = n >>> 1; // unsigned right shift
        }
        
        return count;
    }
}

public class Solution {
    // Time O(1)
    // Space O(1)
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >> 1;
        }
        return result;
    }
}