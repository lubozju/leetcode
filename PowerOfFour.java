/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.
*/

// convert num to number radix 4 and match 1 or 10....
public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}

// num needs to be power of 2 and the only one should be in odd position
public class Solution {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0) && ((0x55555555 & num) != 0);
    }
}