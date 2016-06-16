/*
Given an integer, write a function to determine if it is a power of two.
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}


public class Solution {
    // Time: O(log(n))
    // Space: O(1)
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n >> 1;
        }
        return n == 1;
    }
}